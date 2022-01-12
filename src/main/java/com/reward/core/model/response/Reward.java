package com.reward.core.model.response;

import java.io.Serializable;

public class Reward implements Serializable {
    private int month;
    private int rewardPoints;


    public Reward(int month, int rewardPoints) {
        this.month = month;
        this.rewardPoints = rewardPoints;
    }


    public int getMonth() {
        return month;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cashback{");
        sb.append("month=").append(month);
        sb.append(", rewardPoints=").append(rewardPoints);
        sb.append('}');
        return sb.toString();
    }
}
