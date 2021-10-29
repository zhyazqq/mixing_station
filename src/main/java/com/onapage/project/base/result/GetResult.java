package com.onapage.project.base.result;

import com.onapage.project.base.error.MyErrorMessage;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GetResult<T> extends MyErrorMessage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4774493688452770057L;
	private boolean success;
	
}
