package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCommentListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private String userPicture;
    private String proName;
    private String commentImg;
    private String content;
    private Date createDate;


    public List<String> getCommentImgs() {
        if (StringUtils.isEmpty(this.commentImg)) {
            return new ArrayList<>();

        }
        return Arrays.asList(this.commentImg.split(","));
    }
}
