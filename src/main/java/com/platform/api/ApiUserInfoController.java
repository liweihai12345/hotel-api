package com.platform.api;

import com.platform.service.PartnerService;
import com.platform.vo.PartnerVO;
import com.platform.vo.UserIncomeListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Api(tags = "用户基本信息")
@RestController
@RequestMapping("/api/user")
public class ApiUserInfoController extends ApiBaseAction {
    @Autowired
    private PartnerService partnerService;


    @ApiOperation(value = "我的(个人信息)")
    @ApiImplicitParams({@ApiImplicitParam(name = "token", dataType = "String", paramType = "header", value = "token", required = true)})
    @GetMapping(value = "/info")
    public Object info() {
        PartnerVO partnerVO = partnerService.selectPartnerInfo(getUserId());
        return toResponsSuccess(partnerVO);
    }

    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({@ApiImplicitParam(name = "token", dataType = "String", paramType = "header", value = "token", required = true),
            @ApiImplicitParam(name = "mobile", dataType = "String", paramType = "query", value = "手机号", required = true),
            @ApiImplicitParam(name = "code", dataType = "String", paramType = "query", value = "短信验证码", required = true),
            @ApiImplicitParam(name = "new_pwd", dataType = "String", paramType = "query", value = "新密码", required = true),
            @ApiImplicitParam(name = "again_pwd", dataType = "String", paramType = "query", value = "再次密码", required = true),
    })
    @GetMapping(value = "/modify-pwd")
    public Object modifyPwd(String mobile, String code, String new_pwd, String again_pwd) {
        // 比较密码
        // 加密
//        校验短信验证码

        boolean result = partnerService.updatePassword(getUserId(), new_pwd);

        return toResponsSuccess(result);
    }

    @ApiOperation(value = "申请提现")
    @ApiImplicitParams({@ApiImplicitParam(name = "token", dataType = "String", paramType = "header", value = "token", required = true),
            @ApiImplicitParam(name = "amount", dataType = "String", paramType = "query", value = "提现金额", required = true),
            @ApiImplicitParam(name = "code", dataType = "String", paramType = "query", value = "短信验证码", required = true),
            @ApiImplicitParam(name = "card_no", dataType = "String", paramType = "query", value = "银行卡号", required = true),
            @ApiImplicitParam(name = "card_real_name", dataType = "String", paramType = "query", value = "持卡人姓名", required = true),
            @ApiImplicitParam(name = "opening_bank", dataType = "String", paramType = "query", value = "开户行", required = true),
    })
    @GetMapping(value = "/cash-out")
    public Object cashOut(BigDecimal amount, String code, String card_no, String card_real_name, String opening_bank) {
        //校验短信验证码
//        判空

//        校验金额

        boolean result = partnerService.requestCashOut(getUserId(), amount, card_no, card_real_name, opening_bank);

        return toResponsSuccess(result);
    }

    @ApiOperation(value = "我的(收益明细)")
    @ApiImplicitParams({@ApiImplicitParam(name = "token", dataType = "String", paramType = "header", value = "token", required = true),
            @ApiImplicitParam(name = "index", dataType = "Integer", paramType = "query", value = "页数", required = true),
            @ApiImplicitParam(name = "size", dataType = "Integer", paramType = "query", value = "条数", required = true)})
    @GetMapping(value = "/income-list")
    public Object incomeList(@RequestParam(value = "index" ,defaultValue = "1")Integer index,@RequestParam(value = "size",defaultValue = "5")Integer size) {
        List<UserIncomeListVO> list = partnerService.selectIncomeList(getUserId(),index,size);
        return toResponsSuccess(list);
    }

}
