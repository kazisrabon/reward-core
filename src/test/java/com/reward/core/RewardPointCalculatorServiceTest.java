package com.reward.core;

import com.reward.core.model.entity.TransactionEntity;
import com.reward.core.model.response.RewardDataResponse;
import com.reward.core.service.TransactionDataService;
import com.reward.core.service.impl.SimpleRewardPointCalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RewardPointCalculatorServiceTest {


    @Mock
    private TransactionDataService transactionDataService;

    @InjectMocks
    private SimpleRewardPointCalculatorServiceImpl target;


    @Test
    void should_pass_for_dataset_1() {
        Mockito.when(transactionDataService.getAllTransactionsFor3Months())
                .thenReturn(Arrays.asList(new TransactionEntity("t5", "u2", 1, 100),
                        new TransactionEntity("t6", "u2", 1, 200),
                        new TransactionEntity("t7", "u2", 1, 20),
                        new TransactionEntity("t8", "u2", 2, 510),
                        new TransactionEntity("t9", "u2", 3, 110)));
        RewardDataResponse rewardDataResponse = target.calculateRewardPoint();
        assertEquals(rewardDataResponse.getRewardsPerUser().size(), 1);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().size(), 3);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(0).getRewardPoints(), 300);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(1).getRewardPoints(), 870);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(2).getRewardPoints(), 70);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getTotalRewardPoints(), 1240);
    }

    @Test
    public void should_pass_for_dataset_2() {
        Mockito.when(transactionDataService.getAllTransactionsFor3Months())
                .thenReturn(Arrays.asList(new TransactionEntity("t1", "u1", 1, 100),
                        new TransactionEntity("t2", "u1", 1, 100),
                        new TransactionEntity("t2", "u1", 2, 120),
                        new TransactionEntity("t3", "u1", 2, 110),
                        new TransactionEntity("t4", "u1", 3, 10)));
        RewardDataResponse rewardDataResponse = target.calculateRewardPoint();
        assertEquals(rewardDataResponse.getRewardsPerUser().size(), 1);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().size(), 3);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(0).getRewardPoints(), 100);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(1).getRewardPoints(), 160);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(2).getRewardPoints(), 0);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getTotalRewardPoints(), 260);
    }

    @Test
    public void should_pass_for_dataset_3() {
        Mockito.when(transactionDataService.getAllTransactionsFor3Months())
                .thenReturn(Arrays.asList(new TransactionEntity("t10", "u3", 1, 130),
                        new TransactionEntity("t11", "u3", 2, 280),
                        new TransactionEntity("t12", "u3", 3, 200),
                        new TransactionEntity("t13", "u3", 3, 300),
                        new TransactionEntity("t14", "u3", 3, 310)));
        RewardDataResponse rewardDataResponse = target.calculateRewardPoint();
        assertEquals(rewardDataResponse.getRewardsPerUser().size(), 1);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().size(), 3);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(0).getRewardPoints(), 110);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(1).getRewardPoints(), 410);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(2).getRewardPoints(), 1170);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getTotalRewardPoints(), 1690);
    }


    @Test
    public void should_pass_for_dataset_4() {
        Mockito.when(transactionDataService.getAllTransactionsFor3Months())
                .thenReturn(Arrays.asList(new TransactionEntity("t11", "u4", 1, 120)));
        RewardDataResponse rewardDataResponse = target.calculateRewardPoint();
        assertEquals(rewardDataResponse.getRewardsPerUser().size(), 1);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().size(), 1);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getRewardsPerMonth().get(0).getRewardPoints(), 90);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getTotalRewardPoints(), 90);
        assertEquals(rewardDataResponse.getRewardsPerUser().get(0).getTotalRewardPoints(), 90);

    }
}
