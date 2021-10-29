package com.onapage.project.base.paging;


import com.onapage.project.vo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PagingInfo extends VO {
	private Integer pageNum;
	private Integer pageSize;
	private long total;
	private long pageCount;

}
