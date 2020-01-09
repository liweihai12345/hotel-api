package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;//用户昵称
    private String phone;//手机号
    private BigDecimal price;//奖品价值
    private Integer level;//奖品级别
    private String levelName;//奖品级别
    private String lotteryName;// 奖品名称
    private Date createDate;// 奖品名称

    public String getPhone() {
        if (!StringUtils.isEmpty(this.phone)) {
            phone = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
            return phone;
        }
        return name;
    }
}
