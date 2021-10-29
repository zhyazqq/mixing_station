package com.onapage.project.base.result;

import java.util.List;
import java.util.Map;

import com.onapage.project.base.error.MyErrorMessage;
import com.onapage.project.base.paging.PagingInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class GetResultInfo<T> extends MyErrorMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060438898908360829L;
	private boolean success;
	private List<T> list;
	private Map<String,Object> map;
	private PagingInfo paging;

}
