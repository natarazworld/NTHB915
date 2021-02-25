package com.nt.dao;

import com.nt.entity.InsurancePolicy;

public interface IInsurancePolicyDAO {
     public  InsurancePolicy   getDetailsById(Long policyId);
}
