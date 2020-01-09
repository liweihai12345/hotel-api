package com.platform.task;

import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/18 21:13
 */
@Slf4j
@Component
public class HtmlScheduledTask {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 定时排名
     */
    @Scheduled(cron = "0 0 0/3 * * ? ")
    public void rank() {
        log.info("开始更新排名begin");
        boolean value = redisUtil.lock(Constants.REDIS_RANK_LOCK, "API_RANK_LOCK", 60);
        if (value) {

        }
        log.info("开始更新排名end");
    }

    /**
     * 每日更新注册人数
     */
    @Scheduled(cron = "0 15 0 * * ? ")
    public void initReg() {
        log.info("开始更新注册人数begin");
        boolean value = redisUtil.lock(Constants.SCHEDULED_REG_SNAP_LOCK, "SCHEDULED_REG_SNAP_LOCK", 120);
        if (value) {

        }
        log.info("注册人数end");

    }

    /**
     * 运动距离归零
     */
    @Scheduled(cron = "0 0 0 * * ? ")
    public void initAssetKm() {
        log.info("开始更新运动距离归0begin");
        boolean value = redisUtil.hasKey(Constants.SCHEDULED_RESETKM_LOCK);
        if (!value) {
            redisUtil.set(Constants.SCHEDULED_RESETKM_LOCK, "@Scheduled initAssetKm()", 120);

        }
        log.info("开始更新运动距离归0end");

    }

    /**
     * 每日发币快照
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public void snapTotal() {
        log.info("开始添加运动链发出总量begin");
        boolean value = redisUtil.lock(Constants.SCHEDULED_STATISTICS_LOCK, "SCHEDULED_STATISTICS_LOCK", 180);
        if (value) {
            log.info("添加运动链发出总量执行中。。。");
            String date = DateUtils.format(new Date(), "yyyy-MM-dd");

        }
        log.info("开始添加运动链发出总量end");
    }

    /**
     * 每日统计邀请人返运动链挖矿
     */
    @Scheduled(cron = "0 55 1 * * ?")
    public void runReward() {
        log.info("开始添加运动链挖矿发出begin");
        boolean value = redisUtil.lock(Constants.REDIS_RUN_REWARD_KEY, "REWARD_KEY", 180);
        if (value) {
            log.info("运动链挖矿执行中。。。");
            String date = DateUtils.format(new Date(), "yyyy-MM-dd");

        }
        log.info("开始添加运动链挖矿发出end");
    }

    /**
     * 取消订单
     */
    @Scheduled(cron = "0 30 * * * ?")
    public void cancel() {
        log.info("开始取消订单begin");
        boolean value = redisUtil.lock(Constants.SCHEDULED_CANCEL_ORDER_LOCK, "CANCEL_ORDER_KEY", 180);
        if (value) {
            log.info("自动取消订单执行中。。。");

        }
        log.info("开始取消订单end");
    }

    /**
     * 定时确认收货 每天凌晨1点
     */
    //@Scheduled(cron = "0 0 1 * * ? ")
    public void receiving() {
        log.info("开始完成订单begin");
        boolean value = redisUtil.lock(Constants.REDIS_FINISH_ORDER_KEY, "FINISH_ORDER_KEY", 300);
        if (value) {
            log.info("自动完成订单执行中。。。");

        }
        log.info("开始完成订单end");
    }

    /**
     * 释放能量
     */
    @Scheduled(cron = "0 10 0 * * ? ")
    public void releaseCoin() {
        log.info("开始释放能量归SPCbegin");
        boolean value = redisUtil.lock(Constants.SCHEDULED_RELEASE_COIN_LOCK, "SCHEDULED_RELEASE_COIN_LOCK", 300);
        if (value) {

        }
        log.info("开始释放能量归SPCend");

    }

    /**
     * 执行竞拍结果
     */
    @Scheduled(cron = "2 0 9-20 * * ? ")
    public void auctionFinish() {
        log.info("开始执行竞拍结果begin");
        boolean value = redisUtil.lock(Constants.SCHEDULED_AUCTION_LOCK, "SCHEDULED_AUCTION_LOCK", 50);
        if (value) {

        }
        log.info("开始执行竞拍结果end");

    }

    /**
     * 执行流拍
     */
    @Scheduled(cron = "0 10 9-21 * * ? ")
    public void auctionFinishPass() {
        log.info("开始执行流拍begin");
        boolean value = redisUtil.lock(Constants.SCHEDULED_PASS_LOCK, "SCHEDULED_PASS_LOCK", 50);
        if (value) {

        }
        log.info("开始执行流拍end");

    }

    /**
     * 执行流拍
     */
    @Scheduled(cron = "0 2 0 1 * ? ")
    public void doneOpration() {
        log.info("开始执行D-one-begin");
        boolean value = redisUtil.lock(Constants.REDIS_DONE_LOCK, "REDIS_DONE_LOCK", 50);
        if (value) {

        }
        log.info("开始执行D-one-end");

    }
}
