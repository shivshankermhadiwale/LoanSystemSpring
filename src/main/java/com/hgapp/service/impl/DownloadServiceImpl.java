package com.hgapp.service.impl;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hgapp.controller.ControllerManager;
import com.hgapp.dto.CustContactPersionDto;
import com.hgapp.dto.CustomerDto;
import com.hgapp.service.DownloadService;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class DownloadServiceImpl extends ControllerManager implements DownloadService {
	ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream();
	HashMap<String, Object> pdfData = new HashMap<>();
	// private String fileName = "";

	@Override
	public ResponseEntity<?> customerPdfDownload(Long custId) throws IOException {
		System.out.println("testWSSSS");
		CustomerDto customerDto = this.getServiceManager().getCustomerService().findCustomerDetailById(custId);
		List<CustContactPersionDto> contactPersionDtos = this.getServiceManager().getCustomerService()
				.getCustContactPersionByCustId(custId);
		ByteArrayInputStream bis = generatePdf(customerDto, contactPersionDtos);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=" + "customer_" + customerDto.getFullName() + ".pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	private ByteArrayInputStream generatePdf(CustomerDto customerDto, List<CustContactPersionDto> contactPersionDtos) {

		Document document = new Document(PageSize.A4, 0, 0, 25, 25);
		Font tableHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14f, Font.BOLD);
		Font leftColumnHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12f, Font.NORMAL);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = createPdfTable(2, new float[] { 10, 250 }, 1);
			table.addCell(getCell("Persional Detail", 2, tableHeadingFont));
			table.addCell(getCell("Cust Id", 0, leftColumnHeadingFont));
			table.addCell(getCell(String.valueOf(customerDto.getCustId()), 0, leftColumnHeadingFont));
			table.addCell(getCell("Name", 0, leftColumnHeadingFont));
			table.addCell(getCell(customerDto.getFullName(), 0, leftColumnHeadingFont));
			table.addCell(getCell("Adhar No.", 0, leftColumnHeadingFont));
			table.addCell(getCell(customerDto.getAdharNo(), 0, leftColumnHeadingFont));
			table.addCell(getCell("PAN No.", 0, leftColumnHeadingFont));
			table.addCell(getCell(customerDto.getPanNo(), 0, leftColumnHeadingFont));
			table.addCell(getCell("Address Detail", 2, tableHeadingFont));
			table.addCell(getCell("Address", 0, leftColumnHeadingFont));
			table.addCell(getCell(customerDto.getAddress().getAddress(), 0, leftColumnHeadingFont));
			table.addCell(getCell("Mobile No.", 0, leftColumnHeadingFont));
			table.addCell(getCell(customerDto.getAddress().getPhoneNo(), 0, leftColumnHeadingFont));

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
			document.add(new Phrase("\n\n"));
			document.add(getParagraph("Signature                       "));
			document.add(new Phrase("\n"));
			PdfPTable contactPersionTbl = createPdfTable(2, new float[] { 50, 50 }, 1);
			contactPersionTbl.addCell(getCell("Witness", 2, tableHeadingFont));
			contactPersionTbl.addCell(getCell("Full Name", 0, leftColumnHeadingFont));
			contactPersionTbl.addCell(getCell("Signature", 0, leftColumnHeadingFont));
			if (contactPersionDtos != null && contactPersionDtos.size() > 0) {
				contactPersionDtos.stream().forEach(data -> {
					contactPersionTbl.addCell(getCell(data.getFullName(), 0, leftColumnHeadingFont));
					contactPersionTbl.addCell(getCell("", 0, leftColumnHeadingFont));
				});
			}
			document.add(contactPersionTbl);
			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	public PdfPTable createPdfTable(int columns, float columnWidths[], int tableType) {
		PdfPTable table = null;
		switch (tableType) {
		case 1:
			table = new PdfPTable(columns);
			table.setWidthPercentage(90);
			return table;
		default:
			break;
		}

		return null;
	}

	public PdfPCell getCell(String content, int colspan, Font tableHeadingFont) {
		PdfPCell cell = new PdfPCell(new Phrase(content, tableHeadingFont));
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(colspan);
		return cell;
	}

	public Paragraph getParagraph(String content) {
		Paragraph paragraph = new Paragraph(content);
		paragraph.setPaddingTop(90);
		paragraph.setAlignment(Element.ALIGN_RIGHT);
		return paragraph;
	}

}
