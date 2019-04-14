package com.dsoft.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dsoft.dto.CustContactPersionDto;
import com.dsoft.dto.CustomerDto;
import com.dsoft.entity.CustAddressDetail;
import com.dsoft.entity.CustContactPersion;
import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.CustomerAudit;
import com.dsoft.exception.RecordNotFound;
import com.dsoft.service.CustomerService;
import com.dsoft.service.DaoServicess;

@Transactional
@Service
public class CustomerServiceImpl extends DaoServicess implements CustomerService {

	@Override
	public CustomerDto addNewCustomer(CustomerDto customer) {
		CustPersionalDetail custPersionalDetail = null;
		custPersionalDetail = new CustPersionalDetail();
		custPersionalDetail.setFullName(customer.getFullName());
		if (null != customer.getShortName())
			custPersionalDetail.setShortName(customer.getShortName());
		if (null != customer.getCustType())
			custPersionalDetail.setCustType(customer.getCustType());
		if (null != customer.getGstnNo())
			custPersionalDetail.setGSTINNo(customer.getGstnNo());
		if (null != customer.getPanNo())
			custPersionalDetail.setPANNo(customer.getPanNo());
		if (null != customer.getAdharNo())
			customer.setAdharNo(customer.getAdharNo());
		/*CustomerAudit custAudit = new CustomerAudit();
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
		//custPersionalDetail.setCustAudit(custAudit);
		*/custPersionalDetail = this.getDaoManager().getCustomerDao().addCustomerDetail(custPersionalDetail);
		if (custPersionalDetail == null)
			throw new NullPointerException("Error while Saving Customer Detail");

		if (customer.getAddress() != null) {
			CustAddressDetail addressDetail = new CustAddressDetail();
			if (null != customer.getAddress().getAddress())
				addressDetail.setAddress(customer.getAddress().getAddress());
			/*
			 * if (null != customer.getAddressDto().getCity())
			 * addressDetail.setCity(customer.getAddressDto().getCity()); if (null !=
			 * customer.getAddressDto().getDistrict())
			 * addressDetail.setDistrict(customer.getAddressDto().getDistrict()); if (null
			 * != customer.getAddressDto().getState())
			 * addressDetail.setState(customer.getAddressDto().getState()); if (null !=
			 * customer.getAddressDto().getCountry())
			 * addressDetail.setCountry(customer.getAddressDto().getCountry());
			 */
			if (null != customer.getAddress().getZipCode()&&!customer.getAddress().getZipCode().isEmpty())
				addressDetail.setZipCode(Integer.valueOf(customer.getAddress().getZipCode()));
			if (null != customer.getAddress().getEmail()&&!customer.getAddress().getEmail().isEmpty())
				addressDetail.setEmail(customer.getAddress().getEmail());
			if (null != customer.getAddress().getPhoneNo()&&!customer.getAddress().getPhoneNo().isEmpty())
				addressDetail.setMobNo(customer.getAddress().getPhoneNo());
			addressDetail.setCustomer(custPersionalDetail);
			addressDetail = this.getDaoManager().getCustomerDao().addCustAddressDetail(addressDetail);

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

	@Override
	public CustContactPersionDto addCustContactPersion(CustContactPersionDto contactPersionDto) {
		if (null == contactPersionDto || contactPersionDto.getCustId() == null)
			throw new NullPointerException("Data Missing");
		Optional<CustPersionalDetail> custPersionalDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(contactPersionDto.getCustId());
		if (!custPersionalDetail.isPresent())
			throw new UsernameNotFoundException("Customer Not Found");
		CustContactPersion contactPersions = new CustContactPersion();
		if (null != contactPersionDto.getFullName())
			contactPersions.setFullName(contactPersionDto.getFullName());
		if (null != contactPersionDto.getDesignation())
			contactPersions.setDesignation(contactPersionDto.getDesignation());
		if (contactPersionDto.getAddress() != null) {
			if (null != contactPersionDto.getAddress().getPhoneNo())
				contactPersions.setContactNo(contactPersionDto.getAddress().getPhoneNo());
			if (null != contactPersionDto.getAddress().getEmail())
				contactPersions.setEmail(contactPersionDto.getAddress().getEmail());
		}

		contactPersions.setCustomer(custPersionalDetail.get());
		contactPersions = this.getDaoManager().getCustomerDao().addCustContactPersion(contactPersions);
		if (null != contactPersions) {
			return contactPersionDto;
		}
		return null;

	}

	@Override
	public List<CustContactPersionDto> getCustContactPersionByCustId(Long custId) {
		if (null == custId)
			throw new NullPointerException("Data Missing");
		Optional<CustPersionalDetail> custPersionalDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(custId);
		if (!custPersionalDetail.isPresent())
			throw new UsernameNotFoundException("Customer Not Found");
		List<CustContactPersionDto> contactPersion = null;
		contactPersion = this.getDaoManager().getCustomerDao()
				.getCustContactPersionByCustPersionalDetail(custPersionalDetail.get()).stream().map(data -> {
					CustContactPersionDto contactPersionDto = new CustContactPersionDto();
					contactPersionDto.setFullName(data.getFullName());
					contactPersionDto.setCustId(data.getCustomer().getCustId());
					contactPersionDto.setDesignation(data.getDesignation());
					contactPersionDto.getAddress().setEmail(data.getEmail());
					contactPersionDto.getAddress().setPhoneNo(data.getContactNo());
					return contactPersionDto;
				}).collect(Collectors.toList());
		return contactPersion;
	}

	@Override
	public List<CustPersionalDetail> getAllCustomersLst() {
		return this.getDaoManager().getCustomerDao().getAllCustomersLst();
	}

}
