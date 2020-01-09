package com.platform.service;

import com.platform.entity.NotificationDO;
import com.platform.entity.NotificationRecordDO;
import com.platform.entity.PartnerDO;
import com.platform.mapper.NotificationMapper;
import com.platform.payinterface.push.UmengSendUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/5/31 16:31
 */
@Slf4j
@Service
public class NotificationService {
    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    PartnerService partnerService;

    public NotificationDO selectNotification(String key) {
        List<NotificationDO> list = notificationMapper.selectNotificationList();
        NotificationDO noti = list.stream().filter(o -> o.getKey().equals(key)).findFirst().orElse(null);
        return noti;
    }

    public int insert(NotificationRecordDO recordDO) {
        return notificationMapper.insert(recordDO);
    }

    public void sendNotification(Long uid, Long sendUid, String key) {
        PartnerDO p = partnerService.getPartnerById(uid);
        String token = p.getDeviceTokens();
        Integer deviceType = p.getDeviceType();
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(deviceType)) {
            return;
        }
        NotificationDO noti = this.selectNotification(key);
        NotificationRecordDO recordDO = NotificationRecordDO.builder().uid(uid).ticker(noti.getTicker()).title(noti.getTitle())
                .body(noti.getBody()).linkUrl(noti.getLinkUrl()).targetType(noti.getTargetType()).type(noti.getKey()).build();
        this.insert(recordDO);
        try {
            UmengSendUtil.sendMessageUnicast(recordDO, token, deviceType);
        } catch (Exception e) {
            log.error("友盟消息通知错误");
        }

    }

}
