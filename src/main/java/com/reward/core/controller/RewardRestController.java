package com.reward.core.controller;

import com.reward.core.model.response.RewardDataResponse;
import com.reward.core.service.RewardPointCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reward")
public class RewardRestController {

    @Autowired
    @Qualifier("simpleRewardCalculatorService")
    private RewardPointCalculatorService rewardPointCalculatorService;

    @GetMapping("/calculate")
    public ResponseEntity<RewardDataResponse> calculateCashback() {
        return new ResponseEntity(rewardPointCalculatorService.calculateRewardPoint(), HttpStatus.OK);
    }

}
