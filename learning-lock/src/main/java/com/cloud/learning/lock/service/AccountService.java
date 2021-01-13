package com.cloud.learning.lock.service;

import com.cloud.learning.asserts.Result;
import com.cloud.learning.lock.dal.mapper.AccountMapper;
import com.cloud.learning.lock.dal.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.function.BiPredicate;

/**
 * @ClassName: AccountService
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/13 10:57
 * @Version: 1.0
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;
    private BiPredicate<BigDecimal, BigDecimal> isDepositEnough = (deposit, value) -> deposit.compareTo(value) > 0;

    /**
     * 转账操作，悲观锁
     * @param payment_id 扣款账户
     * @param proceeds_id 收款账户
     * @param money 金额
     * @return
     */
    public Result transferAccounts(String payment_id,String proceeds_id,BigDecimal money){
        Account payment=new Account();  //扣款
        Account proceeds=new Account();  //收款
        return null;
    }
}
