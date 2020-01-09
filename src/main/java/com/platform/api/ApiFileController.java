package com.platform.api;

import com.platform.entity.PartnerDO;
import com.platform.service.*;
import com.platform.util.PathUtils;
import com.platform.util.enums.FileTypeEnum;
import com.platform.vo.AdditionModel;
import com.platform.vo.FilePathVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "上传管理")
@RestController
@RequestMapping("/api/upload")
public class ApiFileController extends ApiBaseAction {
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private FilePathService filePathService;
    @Autowired
    private UserService userService;


    @ApiOperation(value = "头像上传")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token ", required = true)})
    @RequestMapping(value = "/logo")
    public Object updatePartnerPicture(@RequestParam(value = "token", required = false) String token,
                                       @RequestParam(value = "fileName", required = false) String fileName) {

        if (StringUtils.isEmpty(fileName)||StringUtils.isEmpty(fileName.trim())) {
            return toResponsObject(1000, "上传头像不能为空", null);
        }
        FilePathVO vo = filePathService.queryObject(FileTypeEnum.FILE_TYPE_LOGO.getKey());
        String path = PathUtils.splitJoinPath(vo.getEndPoint(), fileName, vo.getBucketName(), vo.getPrefix());
        boolean res = partnerService.updatePictureUrl(getUserId(), path);
        if (!res) {
            return toResponsFail("添加失败");
        }
        PartnerDO partner = partnerService.getPartnerById(getUserId());
        AdditionModel model = userService.getUserLoginInfo(partner,null);
        return toResponsSuccess(model);
    }

    @ApiOperation(value = "获取上传路径")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "fileType", value = "图片类型 1, 头像2, 反馈图片3, 产品图片4, 短视频5, 评论6, 新闻资讯7, 活动8,身份证", required = true)})
    @RequestMapping(value = "/path")
    public Object path(@RequestParam(value = "fileType", required = false) Integer fileType) {
        if (StringUtils.isEmpty(fileType)) {
            return toResponsFail("类型不能为空");
        }
        //获取新闻加商品列表
        FilePathVO vo = filePathService.queryObject(fileType);
        return toResponsSuccess(vo);
    }
}
