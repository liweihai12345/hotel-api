package com.platform.vo;

import com.platform.util.enums.EnergyCoinTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/*能量值*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnergyCoinVO {
    private Integer id;
    private Long uid;
    private String phone;
    private BigDecimal coin;
    private Long inviteUid;
    private String invitePhone;
    private Integer type;
    private String typeStr;
    private String image;
    private Date createDate;

    public String getTypeStr(){
       return EnergyCoinTypeEnum.getValue(this.type).getValue();
    }
    public String getImage(){
        return EnergyCoinTypeEnum.getValue(this.type).getImage();
    }
}
