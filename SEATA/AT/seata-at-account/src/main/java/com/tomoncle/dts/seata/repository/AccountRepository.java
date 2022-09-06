package com.tomoncle.dts.seata.repository;

import com.tomoncle.dts.seata.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserId(String userId);
}
