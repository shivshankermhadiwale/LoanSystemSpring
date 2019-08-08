package com.hgapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hgapp.dto.CustContactPersionDto;
import com.hgapp.dto.CustomerDto;
import com.hgapp.entity.AddressDetail;
import com.hgapp.entity.ContactPersion;
import com.hgapp.entity.CustDetail;
import com.hgapp.exception.RecordNotFound;
import com.hgapp.service.CustService;
import com.hgapp.service.DaoServicess;
import com.hgapp.utils.AppContstants;

@Transactional
@Service
public class CustomerServiceImpl extends DaoServicess implements CustService, AppContstants {

	@Override
	public CustomerDto addNewCustomer(CustomerDto customer) {
		CustDetail custPersionalDetail = null;
		custPersionalDetail = new CustDetail();
		custPersionalDetail.setFullName(customer.getFullName().trim());
		if (null != customer.getShortName())
			custPersionalDetail.setShortName(customer.getShortName());
		if (null != customer.getCustType())
			custPersionalDetail.setCustType(customer.getCustType());
		if (null != customer.getProfessionName())
			custPersionalDetail.setProfessionName(customer.getProfessionName());
		if (null != customer.getGstnNo())
			custPersionalDetail.setGSTINNo(customer.getGstnNo());
		if (null != customer.getPanNo())
			custPersionalDetail.setPANNo(customer.getPanNo());
		if (null != customer.getAdharNo())
			custPersionalDetail.setAdharNo(customer.getAdharNo());


		custPersionalDetail = this.getDaoManager().getCustomerDao().addCustomerDetail(custPersionalDetail);

		if (custPersionalDetail == null)
			throw new NullPointerException("Error while Saving Customer Detail");

		if (customer.getAddress() != null) {
			AddressDetail addressDetail = new AddressDetail();
			if (null != customer.getAddress().getAddress())
				addressDetail.setAddress(customer.getAddress().getAddress());
			
			if (null != customer.getAddress().getZipCode() && !customer.getAddress().getZipCode().isEmpty())
				addressDetail.setZipCode(Integer.valueOf(customer.getAddress().getZipCode()));
			if (null != customer.getAddress().getEmail() && !customer.getAddress().getEmail().isEmpty())
				addressDetail.setEmail(customer.getAddress().getEmail());
			if (null != customer.getAddress().getPhoneNo() && !customer.getAddress().getPhoneNo().isEmpty())
				addressDetail.setPhoneNo1(customer.getAddress().getPhoneNo());
			if (null != customer.getAddress().getNativePlace() && !customer.getAddress().getNativePlace().isEmpty())
				addressDetail.setNativePlace(customer.getAddress().getNativePlace());
			addressDetail.setPersion(custPersionalDetail);
			addressDetail = this.getDaoManager().getCustomerDao().addCustAddressDetail(addressDetail);

		}
		customer.setCustId(custPersionalDetail.getCustId());
		return customer;

	}

	@Override
	public CustomerDto editCustomerDetail(CustomerDto customer) {
		Optional<CustDetail> custDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(customer.getCustId());
		if (!custDetail.isPresent())
			throw new RecordNotFound(" Customer Not Found");
		CustDetail custPersionalDetail = custDetail.get();
		custPersionalDetail.setFullName(customer.getFullName().trim());
		if (null != customer.getShortName())
			custPersionalDetail.setShortName(customer.getShortName());
		if (null != customer.getCustType())
			custPersionalDetail.setCustType(customer.getCustType());
		if (null != customer.getProfessionName())
			custPersionalDetail.setProfessionName(customer.getProfessionName());
		if (null != customer.getGstnNo())
			custPersionalDetail.setGSTINNo(customer.getGstnNo());
		if (null != customer.getPanNo())
			custPersionalDetail.setPANNo(customer.getPanNo());
		if (null != customer.getAdharNo())
			custPersionalDetail.setAdharNo(customer.getAdharNo());

		custPersionalDetail = this.getDaoManager().getCustomerDao().addCustomerDetail(custPersionalDetail);

		if (custPersionalDetail == null)
			throw new NullPointerException("Error while Editing Customer Detail");

		if (customer.getAddress() != null) {
			AddressDetail addressDetail = this.getDaoManager().getCustomerDao()
					.getCustAddDetailByCustId(custPersionalDetail);
			if (null != customer.getAddress().getAddress())
				addressDetail.setAddress(customer.getAddress().getAddress());

			if (null != customer.getAddress().getZipCode() && !customer.getAddress().getZipCode().isEmpty())
				addressDetail.setZipCode(Integer.valueOf(customer.getAddress().getZipCode()));
			if (null != customer.getAddress().getEmail() && !customer.getAddress().getEmail().isEmpty())
				addressDetail.setEmail(customer.getAddress().getEmail());
			if (null != customer.getAddress().getPhoneNo() && !customer.getAddress().getPhoneNo().isEmpty())
				addressDetail.setPhoneNo1(customer.getAddress().getPhoneNo());
			if (null != customer.getAddress().getNativePlace() && !customer.getAddress().getNativePlace().isEmpty())
				addressDetail.setNativePlace(customer.getAddress().getNativePlace());
			addressDetail.setPersion(custPersionalDetail);
			addressDetail = this.getDaoManager().getCustomerDao().addCustAddressDetail(addressDetail);

		}
		customer.setCustId(custPersionalDetail.getCustId());
		return customer;
	}

	@Override
	public CustomerDto findCustomerDetailById(Long custId) {
		Optional<CustDetail> customerEntity = this.getDaoManager().getCustomerDao().findCustomerDetailById(custId);
		if (!customerEntity.isPresent())
			throw new RecordNotFound("Customer Not Found");
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFullName(customerEntity.get().getFullName());
		if (null != customerEntity.get().getShortName())
			customerDto.setShortName(customerEntity.get().getShortName());
		if (null != customerEntity.get().getCustType())
			customerDto.setCustType(customerEntity.get().getCustType());
		if (null != customerEntity.get().getProfessionName())
			customerDto.setProfessionName(customerEntity.get().getProfessionName());
		
		customerDto.setCustId(customerEntity.get().getCustId());

		if (null != customerEntity.get().getPANNo())
			customerDto.setPanNo(customerEntity.get().getPANNo());

		if (null != customerEntity.get().getAdharNo())
			customerDto.setAdharNo(customerEntity.get().getAdharNo());
		AddressDetail custAddressDetail = this.getDaoManager().getCustomerDao()
				.getCustAddDetailByCustId(customerEntity.get());
		if (null != custAddressDetail)
			if (null != custAddressDetail.getAddress())
				customerDto.getAddress().setAddress(custAddressDetail.getAddress());
		
		customerDto.getAddress().setZipCode(String.valueOf(custAddressDetail.getZipCode()));
		if (null != custAddressDetail.getEmail())
			customerDto.getAddress().setEmail(custAddressDetail.getEmail());
		if (null != custAddressDetail.getNativePlace())
			customerDto.getAddress().setNativePlace(custAddressDetail.getNativePlace());
		if (null != custAddressDetail.getPhoneNo1())
			customerDto.getAddress().setPhoneNo(custAddressDetail.getPhoneNo1());
		return customerDto;
	}

	@Override
	public String deleteCustomer(Long custId) {
		/*
		 * if (this.getDaoManager().getCustomerDao().deleteCustomer(custId, true) == 1)
		 * { PersionDetail cust = new PersionDetail(); cust.setPersionId(custId);
		 * CustomerAudit custAudit =
		 * this.getDaoManager().getCustomerDao().findByCustomer(cust);
		 * custAudit.setLastUpdatedDatetime(LocalDateTime.now());
		 * custAudit.setLastUpdatedUserDesignation("NA");
		 * custAudit.setLastUpdatedUserName("LastUsername");
		 * custAudit.setLoggedInUserId("1"); custAudit.setAction("Deleted");
		 * this.getDaoManager().getCustomerDao().saveCustomerAudit(custAudit); return
		 * "Success"; } return "Fail";
		 */
		return null;
	}

	@Override
	public CustContactPersionDto addCustContactPersion(CustContactPersionDto contactPersionDto) {
		if (null == contactPersionDto || contactPersionDto.getCustId() == null)
			throw new NullPointerException("Data Missing");
		Optional<CustDetail> custPersionalDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(contactPersionDto.getCustId());
		if (!custPersionalDetail.isPresent())
			throw new UsernameNotFoundException("Customer Not Found");
		ContactPersion contactPersions = new ContactPersion();
		if (null != contactPersionDto.getFullName())
			contactPersions.setFullName(contactPersionDto.getFullName());
		if (null != contactPersionDto.getDesignation())
			contactPersions.setDesignation(contactPersionDto.getDesignation());
		if (contactPersionDto.getAddress() != null) {
			if (null != contactPersionDto.getAddress().getPhoneNo())
				contactPersions.setPhone1(contactPersionDto.getAddress().getPhoneNo());
			
			if (null != contactPersionDto.getAddress().getAddress())
				contactPersions.setAddress(contactPersionDto.getAddress().getAddress());

		}

		contactPersions.setPersionId(custPersionalDetail.get());
		contactPersions = this.getDaoManager().getCustomerDao().addCustContactPersion(contactPersions);
		contactPersionDto.setContactPersionId(contactPersions.getContactPersionId());
		if (null != contactPersions) {
			return contactPersionDto;
		}
		return null;

	}
	@Override
	public CustContactPersionDto editCustContactPersion(CustContactPersionDto contactPersionDto) {
		Optional<ContactPersion> contactPersion=this.getDaoManager().getCustomerDao().getCustContactPersionsById(contactPersionDto.getContactPersionId());
		if(!contactPersion.isPresent())
			throw new RecordNotFound("Contact Persion Not Found");
		ContactPersion contactPersions = contactPersion.get();
		if (null != contactPersionDto.getFullName())
			contactPersions.setFullName(contactPersionDto.getFullName());
		if (null != contactPersionDto.getDesignation())
			contactPersions.setDesignation(contactPersionDto.getDesignation());
		if (contactPersionDto.getAddress() != null) {
			if (null != contactPersionDto.getAddress().getPhoneNo())
				contactPersions.setPhone1(contactPersionDto.getAddress().getPhoneNo());
			
			if (null != contactPersionDto.getAddress().getAddress())
				contactPersions.setAddress(contactPersionDto.getAddress().getAddress());

		}

		contactPersions = this.getDaoManager().getCustomerDao().addCustContactPersion(contactPersions);
		contactPersionDto.setContactPersionId(contactPersions.getContactPersionId());
		if (null != contactPersions) {
			return contactPersionDto;
		}
		return null;
	}

	@Override
	public List<CustContactPersionDto> getCustContactPersionByCustId(Long custId) {
		if (null == custId)
			throw new NullPointerException("Data Missing");
		Optional<CustDetail> custPersionalDetail = this.getDaoManager().getCustomerDao().findCustomerDetailById(custId);
		if (!custPersionalDetail.isPresent())
			throw new UsernameNotFoundException("Customer Not Found");
		List<CustContactPersionDto> contactPersion = null;
		contactPersion = this.getDaoManager().getCustomerDao()
				.getCustContactPersionByCustPersionalDetail(custPersionalDetail.get()).stream().map(data -> {
					CustContactPersionDto contactPersionDto = new CustContactPersionDto();
					contactPersionDto.setFullName(data.getFullName());
					contactPersionDto.setContactPersionId(data.getContactPersionId());
					contactPersionDto.setCustId(data.getPersionId().getCustId());
					contactPersionDto.setDesignation(data.getDesignation());
					contactPersionDto.getAddress().setAddress(data.getAddress());
					contactPersionDto.getAddress().setPhoneNo(data.getPhone1());
					return contactPersionDto;
				}).collect(Collectors.toList());
		return contactPersion;
	}

	@Override
	public List<CustDetail> getAllCustomersLst() {
		return this.getDaoManager().getCustomerDao().getAllCustomersLst();
	}

	

}
