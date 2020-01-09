package com.platform.vo;

import com.platform.util.enums.OrderInfoEnum;
import com.platform.util.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author lipengjun
 * @email 订单详情对象
 * @date 2017-08-15 08:03:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String orderNo;
    private BigDecimal amount;
    private BigDecimal realAmount;
    private Integer status;
    private Integer type;
    private String statusDesc;
    private String remark;
    private String province;
    private String city;
    private String area;
    private String address;
    private String receiveUser;
    private String receivePhone;
    private Date createDate;
    private Integer payWay;
    private String cause;
    private String logisticsno;
    private Date drawDate;
    private Boolean isComment;
    private Integer merchantId;
    private String merchantName;
    private BigDecimal giveEnergy;
    private BigDecimal spcFree;
    private List<OrderItemVO> list;
    public String getStatusDesc() {
        return OrderStatusEnum.getDesc(this.status);
    }

    public String getCause() {
        if(StringUtils.isEmpty(this.cause)){
            return OrderInfoEnum.getDesc(this.status);
        }
        return cause;
    }
    public String getRealAmountStr() {
        return String.valueOf(this.getRealAmount());
    }
    public String getAmountStr() {
        return String.valueOf(this.getAmount());
    }
}
