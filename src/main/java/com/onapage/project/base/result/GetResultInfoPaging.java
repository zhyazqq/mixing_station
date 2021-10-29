package com.onapage.project.base.result;
import com.onapage.project.base.paging.PagingInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class GetResultInfoPaging<T> extends GetResultInfo<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060438898908360829L;
	private PagingInfo paging;

}
