package com.nt.service;

import com.nt.dao.IInsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDAOImpl;
import com.nt.dto.InsurancePolicyDTO;
import com.nt.entity.InsurancePolicy;

public class InsurancePolicyMgmtServiceImpl implements IInsurancePolicyMgmtService {
	private IInsurancePolicyDAO  dao;
	
	public InsurancePolicyMgmtServiceImpl() {
		dao=new InsurancePolicyDAOImpl();
	}
	

	@Override
	public InsurancePolicyDTO fetchDetailsById(Long policyId) {
		//use DAO
		InsurancePolicy entity=dao.getDetailsById(policyId);
		//convert entity to DTO
		if(entity!=null) {
		InsurancePolicyDTO dto=new InsurancePolicyDTO();
		dto.setPolicyId(entity.getPolicyId());
		dto.setPolicyName(entity.getPolicyName());
		dto.setCompany(entity.getCompany());
		dto.setTenure(entity.getTenure());
		return dto;
		}
		else
			return null;
	}

}
