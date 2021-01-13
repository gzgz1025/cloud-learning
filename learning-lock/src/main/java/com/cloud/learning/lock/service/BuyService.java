package com.cloud.learning.lock.service;

/**
 * @ClassName: BuyService
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/13 14:28
 * @Version: 1.0
 */
public interface BuyService {
    /**
     * 原始购买
     * @return
     */
    String Buy();

    /**
     * 使用乐观锁
     * @return
     */
    String BuyOptimistic();

    /**
     * 使用悲观锁
     * @return
     */
    String BuyPessimism();

    /**
     * 使用分布式锁
     * @return
     */
    String BuyRedis();
}
