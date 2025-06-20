package com.insureme.policy_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/create")
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.createPolicy(policy);
    }

    @PutMapping("/update/{id}")
    public Policy updatePolicy(@PathVariable Long id, @RequestBody Policy updatedPolicy) {
        return policyService.updatePolicy(id, updatedPolicy);
    }

    @GetMapping("/view/{id}")
    public Policy viewPolicy(@PathVariable Long id) {
        return policyService.viewPolicy(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
    }
}
