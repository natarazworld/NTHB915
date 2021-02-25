package com.nt.service;

import com.nt.dto.InsurancePolicyDTO;

public interface IInsurancePolicyMgmtService {
    public  InsurancePolicyDTO  fetchDetailsById(Long policyId);
}
