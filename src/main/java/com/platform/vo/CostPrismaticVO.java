package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 成本费用-柱状
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CostPrismaticVO implements Serializable {
	private static final long serialVersionUID = -6958502979452401684L;
	private Integer id;// 编号


}
