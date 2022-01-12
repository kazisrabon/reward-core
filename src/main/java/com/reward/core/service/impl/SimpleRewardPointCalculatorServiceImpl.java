package com.reward.core.service.impl;

import com.reward.core.model.entity.TransactionEntity;
import com.reward.core.model.response.Reward;
import com.reward.core.model.response.RewardDataResponse;
import com.reward.core.model.response.User;
import com.reward.core.service.RewardPointCalculatorService;
import com.reward.core.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("simpleRewardCalculatorService")
public class SimpleRewardPointCalculatorServiceImpl implements RewardPointCalculatorService {


    @Autowired
    @Qualifier("mockTransactionDataService")
    private TransactionDataService transactionDataService;

    @Override
    public RewardDataResponse calculateRewardPoint() {
        final List<TransactionEntity> allTransactionsFor3Months = transactionDataService.getAllTransactionsFor3Months();
        final List<User> users = new ArrayList<>();
        final Map<String, List<TransactionEntity>> groupByUserId = allTransactionsFor3Months
                .stream()
                .collect(Collectors.groupingBy(TransactionEntity::getUserId));

        groupByUserId.forEach((userId, transactions) -> {
            final Map<Integer, List<TransactionEntity>> transactionsPerUserPerMonth = transactions
                    .stream()
                    .collect(Collectors.groupingBy(TransactionEntity::getMonth));
            final List<Reward> rewards = calculateCashbackPerUser(transactionsPerUserPerMonth);
            final int totalRewardPoints = rewards.stream().collect(Collectors.summingInt(Reward::getRewardPoints));
            final User user = new User(userId, rewards, totalRewardPoints);
            users.add(user);
        });
        return new RewardDataResponse(users);
    }

    private List<Reward> calculateCashbackPerUser(final Map<Integer, List<TransactionEntity>> transactionsPerUserPerMonth) {
        List<Reward> reward = new ArrayList<>();
        transactionsPerUserPerMonth.forEach((month, tnxs) -> {
            int totalRewardsInMonth = 0;
            for (TransactionEntity tnx : tnxs) {
                totalRewardsInMonth += simpleRewardsCalculationPerMonth(tnx);
            }
            reward.add(new Reward(month, totalRewardsInMonth));
        });
        return reward;
    }

    private int simpleRewardsCalculationPerMonth(TransactionEntity tnx) {
        int rewardPointsEarned = 0;
        final int tnxAmount = tnx.getTnxAmount();
        final int over100Spent = tnxAmount - 100;
        if (over100Spent > 0) {
            rewardPointsEarned += over100Spent * 2;
        }
        if (tnx.getTnxAmount() > 50) {
            final int over50 = tnx.getTnxAmount() > 100 ? 50 : tnx.getTnxAmount() - 50;
            rewardPointsEarned += over50;
        }
        return rewardPointsEarned;
    }
}
