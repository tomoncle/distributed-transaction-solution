package com.tomoncle.dts.seata.service;

import com.tomoncle.dts.seata.entity.Account;
import com.tomoncle.dts.seata.repository.AccountRepository;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {
    private Logger logger = LoggerFactory.getLogger(AccountService.class);
    private static final String ERROR_USER_ID = "1002";
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num) {
        logger.info("分布式事务 XID: "+RootContext.getXID());
        Account account = accountRepository.findByUserId(userId);
        account.setMoney(account.getMoney().subtract(num));
        accountRepository.save(account);
        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
