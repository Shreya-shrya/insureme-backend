package com.insureme.policy_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy updatePolicy(Long policyId, Policy updatedPolicy) {
        Optional<Policy> optionalPolicy = policyRepository.findById(policyId);
        if (optionalPolicy.isPresent()) {
            Policy policy = optionalPolicy.get();
            policy.setPolicyHolderName(updatedPolicy.getPolicyHolderName());
            policy.setPolicyType(updatedPolicy.getPolicyType());
            policy.setPremiumAmount(updatedPolicy.getPremiumAmount());
            policy.setStartDate(updatedPolicy.getStartDate());
            policy.setEndDate(updatedPolicy.getEndDate());
            return policyRepository.save(policy);
        } else {
            return null;
        }
    }

    public Policy viewPolicy(Long policyId) {
        return policyRepository.findById(policyId).orElse(null);
    }

    public void deletePolicy(Long policyId) {
        policyRepository.deleteById(policyId);
    }
}
