package com.onapage.project.base.result;

import com.onapage.project.base.error.MyErrorMessage;
import com.onapage.project.vo.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Result<T extends VO> extends MyErrorMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4300890754164025214L;

	private T data;
	private boolean success;

}
