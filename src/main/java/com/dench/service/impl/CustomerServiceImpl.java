package com.dench.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dench.dto.CustomerDto;
import com.dench.entity.CustAddressDetail;
import com.dench.entity.CustPersionalDetail;
import com.dench.entity.CustomerAudit;
import com.dench.exception.RecordNotFound;
import com.dench.service.CustomerService;
import com.dench.service.DaoServicess;

@Transactional
@Service
public class CustomerServiceImpl extends DaoServicess implements CustomerService {

	@Override
	public CustomerDto addNewCustomer(CustomerDto customer) {
		CustPersionalDetail custPersionalDetail = null;
		if (customer == null)
			throw new NullPointerException("customer dto is null");
		custPersionalDetail = new CustPersionalDetail();
		if (null != customer.getFullName())
			custPersionalDetail.setFullName(customer.getFullName());
		if (null != customer.getShortName())
			custPersionalDetail.setShortName(customer.getShortName());
		if (null != customer.getCustType())
			custPersionalDetail.setCustType(customer.getCustType());
		if (null != customer.getGSTINNo())
			custPersionalDetail.setGSTINNo(customer.getGSTINNo());
		if (null != customer.getPANNo())
			customer.setPANNo(customer.getPANNo());
		if (null != customer.getAdharNo())
			customer.setAdharNo(customer.getAdharNo());
		CustomerAudit custAudit = new CustomerAudit();
		custAudit.setAction("Created");
		custAudit.setLastUpdatedDatetime(LocalDateTime.now());
		custAudit.setLastUpdatedUserDesignation("NA");
		custAudit.setLastUpdatedUserId("1");
		custAudit.setLastUpdatedUserName("NA");
		custAudit.setLoggedInUserId("1");
		custAudit.setUserDesignation("NA");
		custAudit.setUserName("NA");
		custAudit.setCustomer(custPersionalDetail);
		custAudit.setCreatedOnDateTime(LocalDateTime.now());
		custPersionalDetail.setCustAudit(custAudit);
		custPersionalDetail = this.getDaoManager().getCustomerDao().addCustomerDetail(custPersionalDetail);
		if (custPersionalDetail == null)
			throw new NullPointerException("Error while Saving Customer Detail");
		
		if (customer.getAddressDto() != null) {
			CustAddressDetail addressDetail = new CustAddressDetail();
			if (null != customer.getAddressDto().getAddress())
				addressDetail.setAddress(customer.getAddressDto().getAddress());
			if (null != customer.getAddressDto().getCity())
				addressDetail.setCity(customer.getAddressDto().getCity());
			if (null != customer.getAddressDto().getDistrict())
				addressDetail.setDistrict(customer.getAddressDto().getDistrict());
			if (null != customer.getAddressDto().getState())
				addressDetail.setState(customer.getAddressDto().getState());
			if (null != customer.getAddressDto().getCountry())
				addressDetail.setCountry(customer.getAddressDto().getCountry());
			if (null != customer.getAddressDto().getZipCode())
				addressDetail.setZipCode(customer.getAddressDto().getZipCode());
			if (null != customer.getAddressDto().getEmail())
				addressDetail.setEmail(customer.getAddressDto().getEmail());
			if (null != customer.getAddressDto().getPhoneNo())
				addressDetail.setMobNo(customer.getAddressDto().getPhoneNo());
			addressDetail.setCustomer(custPersionalDetail);
			addressDetail=this.getDaoManager().getCustomerDao().addCustAddressDetail(addressDetail);

		}
		customer.setCustId(custPersionalDetail.getCustId());
		return customer;
		
		
	}

	@Override
	public CustPersionalDetail findCustomerDetailById(Long custId) {
		Optional<CustPersionalDetail> customerEntity = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(custId);
		if (!customerEntity.isPresent())
			throw new RecordNotFound("Customer Not Found");
		return customerEntity.get();
	}

	@Override
	public String deleteCustomer(Long custId) {
		if (this.getDaoManager().getCustomerDao().deleteCustomer(custId, true) == 1) {
			CustPersionalDetail cust = new CustPersionalDetail();
			cust.setCustId(custId);
			CustomerAudit custAudit = this.getDaoManager().getCustomerDao().findByCustomer(cust);
			custAudit.setLastUpdatedDatetime(LocalDateTime.now());
			custAudit.setLastUpdatedUserDesignation("NA");
			custAudit.setLastUpdatedUserName("LastUsername");
			custAudit.setLoggedInUserId("1");
			custAudit.setAction("Deleted");
			this.getDaoManager().getCustomerDao().saveCustomerAudit(custAudit);
			return "Success";
		}
		return "Fail";
	}

}
