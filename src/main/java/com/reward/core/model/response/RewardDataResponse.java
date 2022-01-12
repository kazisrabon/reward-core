package com.reward.core.model.response;

import java.io.Serializable;
import java.util.List;

public class RewardDataResponse implements Serializable {

    private List<User> rewardsPerUser;


    public RewardDataResponse(List<User> rewardsPerUser) {
        this.rewardsPerUser = rewardsPerUser;
    }

    public RewardDataResponse() {
    }


    public List<User> getRewardsPerUser() {
        return rewardsPerUser;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RewardDataResponse{");
        sb.append("rewardsPerUser=").append(rewardsPerUser);
        sb.append('}');
        return sb.toString();
    }
}
