package com.reward.core.service;

import com.reward.core.model.entity.TransactionEntity;

import java.util.List;

public interface TransactionDataService {


    List<TransactionEntity> getAllTransactionsFor3Months();
}
