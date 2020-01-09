package com.platform.vo;

import com.platform.entity.StudyDO;
import com.platform.entity.StudyVideoDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/9 12:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudyVO {
    private List<StudyDO> courses;
    private List<StudyVideoDO> videos;
    private List<StudyDO> books;
    private List<StudyDO> cases;
}
