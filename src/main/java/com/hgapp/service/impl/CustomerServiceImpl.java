package com.hgapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hgapp.config.AppContstants;
import com.hgapp.dto.CustContactPersionDto;
import com.hgapp.dto.CustomerDto;
import com.hgapp.entity.AddressDetail;
import com.hgapp.entity.ContactPersion;
import com.hgapp.entity.CustDetail;
import com.hgapp.exception.RecordNotFound;
import com.hgapp.service.CustService;
import com.hgapp.service.DaoServicess;

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

		/*
		 * CustomerAudit custAudit = new CustomerAudit();
		 * custAudit.setAction("Created");
		 * custAudit.setLastUpdatedDatetime(LocalDateTime.now());
		 * custAudit.setLastUpdatedUserDesignation("NA");
		 * custAudit.setLastUpdatedUserId("1"); custAudit.setLastUpdatedUserName("NA");
		 * custAudit.setLoggedInUserId("1"); custAudit.setUserDesignation("NA");
		 * custAudit.setUserName("NA"); custAudit.setCustomer(custPersionalDetail);
		 * custAudit.setCreatedOnDateTime(LocalDateTime.now());
		 * //custPersionalDetail.setCustAudit(custAudit);
		 */

		custPersionalDetail = this.getDaoManager().getCustomerDao().addCustomerDetail(custPersionalDetail);

		if (custPersionalDetail == null)
			throw new NullPointerException("Error while Saving Customer Detail");

		if (customer.getAddress() != null) {
			AddressDetail addressDetail = new AddressDetail();
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
		/*
		 * if (null != customerEntity.get().getGstnNo())
		 * customerDto.setGSTINNo(customer.getGstnNo());
		 */
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
			/*
			 * if (null != contactPersionDto.getAddress().getEmail())
			 * contactPersions.setEmail(contactPersionDto.getAddress().getEmail());
			 */
			if (null != contactPersionDto.getAddress().getAddress())
				contactPersions.setAddress(contactPersionDto.getAddress().getAddress());

		}

		contactPersions.setPersionId(custPersionalDetail.get());
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
		Optional<CustDetail> custPersionalDetail = this.getDaoManager().getCustomerDao().findCustomerDetailById(custId);
		if (!custPersionalDetail.isPresent())
			throw new UsernameNotFoundException("Customer Not Found");
		List<CustContactPersionDto> contactPersion = null;
		contactPersion = this.getDaoManager().getCustomerDao()
				.getCustContactPersionByCustPersionalDetail(custPersionalDetail.get()).stream().map(data -> {
					CustContactPersionDto contactPersionDto = new CustContactPersionDto();
					contactPersionDto.setFullName(data.getFullName());
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
