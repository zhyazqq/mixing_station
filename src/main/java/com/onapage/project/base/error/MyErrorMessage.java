package com.onapage.project.base.error;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.onapage.project.vo.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyErrorMessage extends VO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5753943945739159259L;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer code;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;

}
