package com.hgapp.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
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
import com.hgapp.dto.FDAccountDto;
import com.hgapp.dto.LoanRepoDto;
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
		CustomerDto customerDto = this.getServiceManager().getCustomerService().findCustomerDetailById(custId);
		List<CustContactPersionDto> contactPersionDtos = this.getServiceManager().getCustomerService()
				.getCustContactPersionByCustId(custId);
		ByteArrayInputStream bis = generatePdf(customerDto, contactPersionDtos);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=" + "customer_" + customerDto.getFullName() + ".pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@Override
	public ResponseEntity<?> downloandLoanAccounts(String status) {
		List<LoanRepoDto> loanRepolst=this.getServiceManager().getLoanService().getAllLoanAccount(status);
		ByteArrayInputStream bis = generateLoanAccountsPdf(loanRepolst);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=" + "LoanReport_" + LocalDate.now()+ ".pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	
	}

	@Override
	public ResponseEntity<?> downloandCustomerFD(Long fdId) {
		FDAccountDto fdAccountDto=this.getServiceManager().getFdAccountService().getFDAccountDtlByAccountId(fdId);
		ByteArrayInputStream bis = generateCustomerFDPDF(fdAccountDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=" + "CustFD_" + LocalDate.now()+ ".pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	private ByteArrayInputStream generateCustomerFDPDF(FDAccountDto fdAccountDto) {

		Document document = new Document(PageSize.A4, 0, 0, 50, 50);
		Font tableHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16f, Font.BOLD);
		
		Font leftColumnHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14f, Font.NORMAL);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			PdfPTable table = createPdfTable(2, new float[] { 10, 250 }, 1);
			table.addCell(getCell("FD Receipt", 2, tableHeadingFont));
			table.addCell(getCell("Name", 0, leftColumnHeadingFont));
			table.addCell(getCell(fdAccountDto.getCustName(), 0, leftColumnHeadingFont));
			table.addCell(getCell("Account No", 0, leftColumnHeadingFont));
			table.addCell(getCell(String.valueOf(fdAccountDto.getAccountNo()), 0, leftColumnHeadingFont));
			table.addCell(getCell("Amount", 0, leftColumnHeadingFont));
			table.addCell(getCell(String.valueOf(fdAccountDto.getAmount()), 0, leftColumnHeadingFont));
			table.addCell(getCell("Interest", 0, leftColumnHeadingFont));
			table.addCell(getCell(String.valueOf(fdAccountDto.getInterest()), 0, leftColumnHeadingFont));
			table.addCell(getCell("Interest Amount", 0, leftColumnHeadingFont));
			table.addCell(getCell(String.valueOf(fdAccountDto.getInterestAmt()), 0, leftColumnHeadingFont));
			table.addCell(getCell("Start Date", 0, leftColumnHeadingFont));
			table.addCell(getCell(String.valueOf(fdAccountDto.getStartDate()), 0, leftColumnHeadingFont));
			table.addCell(getCell("End Date", 0, leftColumnHeadingFont));
			table.addCell(getCell(String.valueOf(fdAccountDto.getEndDate()), 0, leftColumnHeadingFont));
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
			document.add(new Paragraph("\n\n"));
			PdfPTable receipt = createPdfTable(2, new float[] { 10, 250 }, 1);
			receipt.addCell(getCell("FD Receipt", 2, tableHeadingFont));
			receipt.addCell(getCell("Name", 0, leftColumnHeadingFont));
			receipt.addCell(getCell(fdAccountDto.getCustName(), 0, leftColumnHeadingFont));
			receipt.addCell(getCell("Account No", 0, leftColumnHeadingFont));
			receipt.addCell(getCell(String.valueOf(fdAccountDto.getAccountNo()), 0, leftColumnHeadingFont));
			receipt.addCell(getCell("Amount", 0, leftColumnHeadingFont));
			receipt.addCell(getCell(String.valueOf(fdAccountDto.getAmount()), 0, leftColumnHeadingFont));
			receipt.addCell(getCell("Interest", 0, leftColumnHeadingFont));
			receipt.addCell(getCell(String.valueOf(fdAccountDto.getInterest()), 0, leftColumnHeadingFont));
			receipt.addCell(getCell("Interest Amount", 0, leftColumnHeadingFont));
			receipt.addCell(getCell(String.valueOf(fdAccountDto.getInterestAmt()), 0, leftColumnHeadingFont));
			receipt.addCell(getCell("Start Date", 0, leftColumnHeadingFont));
			receipt.addCell(getCell(String.valueOf(fdAccountDto.getStartDate()), 0, leftColumnHeadingFont));
			receipt.addCell(getCell("End Date", 0, leftColumnHeadingFont));
			receipt.addCell(getCell(String.valueOf(fdAccountDto.getEndDate()), 0, leftColumnHeadingFont));
			document.add(receipt);
			document.close();

		} catch (DocumentException ex) {
			
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
	private ByteArrayInputStream generateLoanAccountsPdf(List<LoanRepoDto> loanRepolst) {

		Document document = new Document(PageSize.A4, 0, 0, 50, 50);
		Font tableHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14f, Font.BOLD);
		Font tableColHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12f, Font.BOLD);
		Font leftColumnHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10f, Font.NORMAL);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable loanDtlstable = createPdfTable(8,new float[] {20,10,10,10,10,10,10,10},1);
			loanDtlstable.addCell(getCell("Loan Accounts", 8, tableHeadingFont));
			loanDtlstable.addCell(getCell("Customer Name", 0, tableColHeadingFont));
			loanDtlstable.addCell(getCell("Account No.", 0, tableColHeadingFont));
			loanDtlstable.addCell(getCell("Principal Amt", 0, tableColHeadingFont));
			loanDtlstable.addCell(getCell("Loan Amt", 0, tableColHeadingFont));
			loanDtlstable.addCell(getCell("Collection", 0, tableColHeadingFont));
			loanDtlstable.addCell(getCell("Remaing Collection", 0, tableColHeadingFont));
			loanDtlstable.addCell(getCell("Disbursement Date", 0, tableColHeadingFont));
			loanDtlstable.addCell(getCell("Ending Date", 0, tableColHeadingFont));
			PdfWriter.getInstance(document, out);
			if (loanRepolst != null && loanRepolst.size() > 0) {
				loanRepolst.stream().forEach(data -> {
					loanDtlstable.addCell(getCell(data.getFullName(), 0, leftColumnHeadingFont));
					loanDtlstable.addCell(getCell(String.valueOf(data.getLoanAccountNo()), 0, leftColumnHeadingFont));
					loanDtlstable.addCell(getCell(String.valueOf(data.getPrincipalAmount()), 0, leftColumnHeadingFont));
					loanDtlstable.addCell(getCell(String.valueOf(data.getLoanAmt()), 0, leftColumnHeadingFont));
					loanDtlstable.addCell(getCell(data.getTotalCollection()==null?"":String.valueOf(data.getTotalCollection()), 0, leftColumnHeadingFont));
					loanDtlstable.addCell(getCell(data.getRemainCollection()==null?"":String.valueOf(data.getRemainCollection()), 0, leftColumnHeadingFont));
					loanDtlstable.addCell(getCell(data.getPaymentDate()==null?"":String.valueOf(data.getPaymentDate()), 0, leftColumnHeadingFont));
					loanDtlstable.addCell(getCell(data.getLoanEndigDate()==null?"":String.valueOf(data.getLoanEndigDate()), 0, leftColumnHeadingFont));
				
				});
			}
			document.open();
			document.add(loanDtlstable);
			document.close();

		} catch (DocumentException ex) {
			
		}

		return new ByteArrayInputStream(out.toByteArray());
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
