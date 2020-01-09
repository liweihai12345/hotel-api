package com.platform.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:14
 */
public class OrderNoUtils {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final AtomicInteger atomicInteger = new AtomicInteger(100);

    /**
     * 创建不连续的订单号
     *
     * @param no
     *            数据中心编号
     * @return 唯一的、不连续订单号
     */
    public static synchronized String getOrderNoByUUID(String no) {
        Integer uuidHashCode = UUID.randomUUID().toString().hashCode();
        if (uuidHashCode < 0) {
            uuidHashCode = uuidHashCode * (-1);
        }
        String date = simpleDateFormat.format(new Date());
        return no + date + uuidHashCode;
    }

    /**
     * 获取同一秒钟 生成的订单号连续
     *
     *            数据中心编号
     * @return 同一秒内订单连续的编号
     */
    public static synchronized String getOrderNoByAtomic() {
        atomicInteger.getAndIncrement();
        int i = atomicInteger.get();
        String date = simpleDateFormat.format(new Date());
        return date + i;
    }
    //兑换单号
    public static synchronized String getExNoByUUID(String no) {
        String date = simpleDateFormat.format(new Date());
        return no + date ;
    }
    //提现单号
    public static synchronized String getCashByUUID(String no) {
        String date = simpleDateFormat.format(new Date());
        return no + date ;
    }
    //转账单号
    public static synchronized String getTransferByUID(String no) {
        String date = simpleDateFormat.format(new Date());
        return no + date ;
    }
    //转账单号
    public static synchronized String getTempOrderNo(Long userId) {
        atomicInteger.getAndIncrement();
        int i = atomicInteger.get();
        String date = simpleDateFormat.format(new Date());
        return userId + date + i;
    }

}
