package com.reward.core.model.entity;

import java.io.Serializable;

public class TransactionEntity implements Serializable {


    private String tnxId;
    private String userId;
    private int month;
    private int tnxAmount;


    public TransactionEntity(String tnxId, String userId, int month, int tnxAmount) {
        this.tnxId = tnxId;
        this.userId = userId;
        this.month = month;
        this.tnxAmount = tnxAmount;
    }


    public String getTnxId() {
        return tnxId;
    }

    public String getUserId() {
        return userId;
    }

    public int getMonth() {
        return month;
    }

    public int getTnxAmount() {
        return tnxAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (month != that.month) return false;
        if (tnxAmount != that.tnxAmount) return false;
        if (tnxId != null ? !tnxId.equals(that.tnxId) : that.tnxId != null) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        int result = tnxId != null ? tnxId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + month;
        result = 31 * result + tnxAmount;
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransactionEntity{");
        sb.append("tnxId='").append(tnxId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", month=").append(month);
        sb.append(", tnxAmount=").append(tnxAmount);
        sb.append('}');
        return sb.toString();
    }
}
