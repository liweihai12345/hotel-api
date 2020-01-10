package com.platform.api;

import com.platform.service.HomeService;
import com.platform.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "首页")
@RestController
@RequestMapping("/api/home")
public class ApiHomeController extends ApiBaseAction {
    @Autowired
    private HomeService homeService;

    @ApiOperation("首页-banner")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true)})
    @GetMapping(value = "/banner")
    public Object banner() {
        List<BannerVO> banners = homeService.selectHomeBanners();
        return toResponsSuccess(banners);
    }

    @ApiOperation("首页-消息公告")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "type", dataType = "Integer", paramType = "query", name = "类型", required = true)})
    @GetMapping(value = "/notice")
    public Object notice(Integer type) {
        List<NoticeVO> notices = homeService.selectHomeNotices(type);
        return toResponsSuccess(notices);
    }

    @ApiOperation("首页-客房入住")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true)})
    @GetMapping(value = "/index")
    public Object index() {
        GuestRoomVO roomVO = homeService.selectHomeGuestRoom();
        return toResponsSuccess(roomVO);
    }

    @ApiOperation("首页-客房入住-历史列表")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "start_date", dataType = "string", paramType = "query", name = "开始时间", required = false),
            @ApiImplicitParam(value = "end_date", dataType = "string", paramType = "query", name = "结束时间", required = false)})
    @GetMapping(value = "/room-history")
    public Object roomHistory(String start_date, String end_date) {
        //开始时间和结束时间为空的话
        List<GuestRoomListVO> list = homeService.selectHomeGuestRoomHistory(start_date, end_date);
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-客房入住-曲线1")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "start_date", dataType = "string", paramType = "query", name = "开始时间", required = false),
            @ApiImplicitParam(value = "end_date", dataType = "string", paramType = "query", name = "结束时间", required = false)})
    @GetMapping(value = "/room-curve1")
    public Object roomCurve1(String start_date, String end_date) {
        //开始时间和结束时间为空的话
        GuestRoomCurveVO list = null;
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-客房入住-曲线2")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "start_date", dataType = "string", paramType = "query", name = "开始时间", required = false),
            @ApiImplicitParam(value = "end_date", dataType = "string", paramType = "query", name = "结束时间", required = false)})
    @GetMapping(value = "/room-curve2")
    public Object roomCurve2(String start_date, String end_date) {
        //开始时间和结束时间为空的话
        GuestRoomSaleCurveVO list = null;
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-成本费用")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "月份", required = false)})
    @GetMapping(value = "/cost")
    public Object cost(String month_date) {
        CostVO costVO = homeService.selectHomeCost(month_date);
        return toResponsSuccess(costVO);
    }

    @ApiOperation("首页-成本费用-历史列表")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "月份", required = false)})
    @GetMapping(value = "/cost-history")
    public Object costHistory(String month_date) {
        List<CostListVO> listVOS = homeService.selectHomeCostHistory(month_date);
        return toResponsSuccess(listVOS);
    }

    @ApiOperation("首页-成本费用-柱状")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "月份", required = false)})
    @GetMapping(value = "/cost-prismatic")
    public Object costPrismatic(String month_date) {
        CostPrismaticVO listVOS = null;
        return toResponsSuccess(listVOS);
    }

    @ApiOperation("首页-营收费用")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "日期", required = false)})
    @GetMapping(value = "/operating-income")
    public Object operatingIncome(String month_date) {
        IncomeVO incomeVO = homeService.selectHomeOperatingIncome(month_date);
        return toResponsSuccess(incomeVO);
    }

    @ApiOperation("首页-营收费用-历史列表")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "日期", required = false)})
    @GetMapping(value = "/income-history")
    public Object incomeHistory(String month_date) {
        List<IncomeListVO> list = homeService.selectHomeIncomeHistory(month_date);
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-营收费用-饼状图")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "日期", required = false)})
    @GetMapping(value = "/income-pie")
    public Object incomePie(String month_date) {
        IncomePieVO list = null;
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-财务报表")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "日期", required = false)
    })
    @GetMapping(value = "/finance")
    public Object finance(String month_date) {
        FinanceVO financeVO = homeService.selectHomeFinance(month_date);
        return toResponsSuccess(financeVO);
    }

    @ApiOperation("首页-财务报表")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "日期", required = false)
    })
    @GetMapping(value = "/finance-order")
    public Object financeOrder(String month_date) {
        List<FinanceOrderListVO> list = homeService.selectHomeFinanceOrder(month_date);
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-财务报表-曲线")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "日期", required = false)
    })
    @GetMapping(value = "/finance-curve")
    public Object financeCurve(String month_date) {
        List<FinanceOrderListVO> list = homeService.selectHomeFinanceOrder(month_date);
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-个人盈亏毛利")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
    })
    @GetMapping(value = "/gross-profit")
    public Object grossProfit() {
        GrossProfitVO gross = homeService.selectHomeGrossProfit();
        return toResponsSuccess(gross);
    }

    @ApiOperation("首页-个人盈亏毛利详情列表")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "start", dataType = "string", paramType = "query", name = "开始日期", required = false),
            @ApiImplicitParam(value = "end", dataType = "string", paramType = "query", name = "结束日期", required = false)})
    @GetMapping(value = "/gross-profit")
    public Object grossProfitList(String start, String end) {
        List<GrossProfitListVO> list = homeService.selectHomeGrossProfitList(start, end);
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-个人盈亏毛利详情-柱状")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "start", dataType = "string", paramType = "query", name = "开始日期", required = false),
            @ApiImplicitParam(value = "end", dataType = "string", paramType = "query", name = "结束日期", required = false)})
    @GetMapping(value = "/profit-prismatic")
    public Object grossProfitPrismatic(String start, String end) {
        GrossProfitPrismaticVO list = null;
        return toResponsSuccess("");
    }

    @ApiOperation("首页-盈亏净利")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "日期", required = false)})
    @GetMapping(value = "/net-income")
    public Object netIncome(String month_date) {
        NetIncomeVO netIncome = homeService.selectHomeNetIncome(month_date);
        return toResponsSuccess(netIncome);
    }

    @ApiOperation("首页-盈亏净利-柱状")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "month_date", dataType = "string", paramType = "query", name = "日期", required = false)})
    @GetMapping(value = "/net-income-prismatic")
    public Object netIncomePrismatic(String month_date) {
        NetIncomeVO netIncome = homeService.selectHomeNetIncome(month_date);
        return toResponsSuccess(netIncome);
    }


    @ApiOperation("首页-维护基金")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true)})
    @GetMapping(value = "/maintenance")
    public Object maintenance() {
        MaintenanceVO maintenance = homeService.selectHomeMaintenance();
        return toResponsSuccess(maintenance);
    }

    @ApiOperation("首页-维护基金-列表")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "start", dataType = "string", paramType = "query", name = "开始日期", required = false),
            @ApiImplicitParam(value = "end", dataType = "string", paramType = "query", name = "结束日期", required = false)})
    @GetMapping(value = "/maintenance-list")
    public Object maintenanceList(String start, String end) {
        List<MaintenanceListVO> list = homeService.selectHomeMaintenanceList(start, end);
        return toResponsSuccess(list);
    }

    @ApiOperation("首页-维护基金-柱状图-七日收入支出")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true),
            @ApiImplicitParam(value = "start", dataType = "string", paramType = "query", name = "开始日期", required = false)})
    @GetMapping(value = "/maintenance-prismatic")
    public Object maintenancePrismatic() {
        MaintenancePrismaticVO prismatic = null;
        return toResponsSuccess("");
    }

    //    --------
    @ApiOperation("首页-酒店日常")
    @ApiImplicitParams({@ApiImplicitParam(value = "token", dataType = "string", paramType = "header", name = "token", required = true)})
    @GetMapping(value = "/hotel-daily")
    public Object hotelDaily() {
        Map<String, Object> map = homeService.selectHomeConfig(getUserId());
        return toResponsSuccess(map);
    }


}
