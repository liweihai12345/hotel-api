package com.platform.vo;

import com.platform.util.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * @author  财务订单收支明细
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinanceOrderListVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String orderNo;//订单号
    private String roomNo;// 房间号
    private String settleType;//收支类型
    private String settleTypeName;//收支类型名
    private String amount;//金额
    private String createDate;//日期




}
