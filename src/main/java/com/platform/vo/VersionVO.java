package com.platform.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/9 17:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VersionVO implements Serializable {
    private Integer id; // apk 下载地址
    private String apk; // apk 下载地址
    private String msg; // 版本新增功能说明
    private String versionCode; // 版本号
    private String versionName;// 版本名称
    private Integer mustUpdate;// 是否强制更新默认0不弹框，1弹框，2强制更新
    private String fileMd5;//文件md5码
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;//创建时间
}
