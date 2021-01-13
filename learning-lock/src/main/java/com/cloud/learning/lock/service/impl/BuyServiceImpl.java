package com.cloud.learning.lock.service.impl;

import com.cloud.learning.lock.dal.mapper.PayOrderMapper;
import com.cloud.learning.lock.dal.mapper.ProductMapper;
import com.cloud.learning.lock.dal.model.PayOrder;
import com.cloud.learning.lock.dal.model.Product;
import com.cloud.learning.lock.service.BuyService;
import com.cloud.learning.utils.Ids;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;


/**
 * @ClassName: BuyServiceImpl
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/13 14:28
 * @Version: 1.0
 */
@Slf4j
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private PayOrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;
    /**
     * 购买商品操作
     * @return
     */
    @Override
    public String Buy() {
        //判断有无库存
        Product product=productMapper.selectByPrimaryKey(1);
        if(ObjectUtils.isEmpty(product)||product.getNumber()<=0){
            log.info("操作1、2：库存不足");
            return "操作1、2：库存不足";
        }

        //减库存
        int result=productMapper.reduceOrder();
        if(result==1){
            //生成订单
            PayOrder order = new PayOrder();
            order.setOrderId(Ids.gid());
            orderMapper.insertSelective(order);
            log.info("操作1、2：购买成功");
            return "操作1、2：购买成功";
        }else{
            return "操作1、2：购买失败";
        }
    }

    /**
     * 乐观锁
     * @return
     */
    @Override
    public String BuyOptimistic() {
        /** 先判断是否有库存 */
        Product product = productMapper.selectByPrimaryKey(1);
        if (ObjectUtils.isEmpty(product)||product.getNumber() <= 0) {
            log.info("操作3：库存不足");
            return "操作3：库存不足！";
        } else {
            /** 减库存 */
            int i = productMapper.reduceOrderOptimistic(product.getVersion());
            if (i == 1) {
                /** 生成订单 */
                PayOrder order = new PayOrder();
                order.setOrderId(Ids.gid());
                orderMapper.insertSelective(order);
                log.info("操作3：购买成功");
                return "操作3：购买成功！";
            } else {
                log.info("操作3：购买失败");
                return "操作3：购买失败！";
            }
        }
    }

    /**
     * 悲观锁
     * @return
     */
    @Transactional
    @Override
    public String BuyPessimism() {
        /** 先判断是否有库存 */
//        Product product = productMapper.selectByPrimaryKey(1);
        Product product = productMapper.selectWithPessimism(1);
        if (ObjectUtils.isEmpty(product)||product.getNumber() <= 0) {
            log.info("操作4：库存不足");
            return "操作4：库存不足！";
        } else {
            /** 减库存 */
            int i =productMapper.reduceOrder();
            if (i == 1) {
                /** 生成订单 */
                PayOrder order = new PayOrder();
                order.setOrderId(Ids.gid());
                orderMapper.insertSelective(order);
                log.info("操作4：购买失败");
                return "操作4：购买成功！";
            } else {
                log.info("操作4：购买失败");
                return "操作4：购买失败！";
            }
        }
    }

    /**
     * 使用Redis锁 分布式
     * @return
     */
    @Override
    public String BuyRedis() {
        String key = "key_product";
        RLock lock = redissonClient.getLock(key);
        try {
            lock.lock();
            /** 先判断是否有库存 */
            Product product = productMapper.selectByPrimaryKey(1);
            if (product.getNumber() <= 0) {
                log.info("操作5：库存不足");
                return "操作5：库存不足！";
            } else {
                /** 减库存 */
                int i =productMapper.reduceOrder();
                if (i == 1) {
                    /** 生成订单 */
                    PayOrder order = new PayOrder();
                    order.setOrderId(Ids.gid());
                    orderMapper.insertSelective(order);
                    log.info("操作5：购买成功");
                    return "操作5：购买成功！";
                } else {
                    log.info("操作5：购买失败");
                    return "操作5：购买失败！";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "";
    }


    /**
     * redisson常用加锁方法
     */
    public void RedisLock() {
        RLock lock = redissonClient.getLock("anyLock");

        try {
            /** 1. 最常见的使用方法 */
            lock.lock();
            /** 2. 支持过期解锁功能,10秒钟以后自动解锁, 无需调用unlock方法手动解锁 */
            lock.lock(10, TimeUnit.SECONDS);

            /** 3. 尝试加锁，最多等待3秒，上锁以后10秒自动解锁 */
            boolean res = lock.tryLock(3, 10, TimeUnit.SECONDS);
            if (res) {
                /** do your business */
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
