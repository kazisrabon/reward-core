package com.reward.core.model.response;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String userId;
    private List<Reward> rewardsPerMonth;
    private int totalRewardPoints;


    public User(String userId, List<Reward> rewardsPerMonth, int totalRewardPoints) {
        this.userId = userId;
        this.rewardsPerMonth = rewardsPerMonth;
        this.totalRewardPoints = totalRewardPoints;
    }


    public String getUserId() {
        return userId;
    }

    public List<Reward> getRewardsPerMonth() {
        return rewardsPerMonth;
    }

    public int getTotalRewardPoints() {
        return totalRewardPoints;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", rewardsPerMonth=").append(rewardsPerMonth);
        sb.append(", totalRewardPoints=").append(totalRewardPoints);
        sb.append('}');
        return sb.toString();
    }
}
