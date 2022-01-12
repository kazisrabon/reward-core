package com.reward.core.service.impl;

import com.reward.core.model.entity.TransactionEntity;
import com.reward.core.service.TransactionDataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service("mockTransactionDataService")
public class MockTransactionDataServiceImpl implements TransactionDataService {
    @Override
    public List<TransactionEntity> getAllTransactionsFor3Months() {
        return Arrays.asList(new TransactionEntity("t1", "u1", 1, 100),
                new TransactionEntity("t2", "u1", 1, 100),
                new TransactionEntity("t2", "u1", 2, 120),
                new TransactionEntity("t3", "u1", 2, 110),
                new TransactionEntity("t4", "u1", 3, 10),

                new TransactionEntity("t5", "u2", 1, 100),
                new TransactionEntity("t6", "u2", 1, 200),
                new TransactionEntity("t7", "u2", 1, 20),
                new TransactionEntity("t8", "u2", 2, 510),
                new TransactionEntity("t9", "u2", 3, 110),

                new TransactionEntity("t10", "u3", 1, 130),
                new TransactionEntity("t11", "u3", 2, 280),
                new TransactionEntity("t12", "u3", 3, 200),
                new TransactionEntity("t13", "u3", 3, 300),
                new TransactionEntity("t14", "u3", 3, 310),

                new TransactionEntity("t11", "u4", 1, 120)
        );


    }
}
