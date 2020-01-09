package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilePathVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String endPoint;
    private String prefix;
    private Integer type;
    private Date createDate;
    private Integer statu;

}
