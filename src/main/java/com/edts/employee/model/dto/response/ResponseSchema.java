package com.edts.employee.model.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by Spring Tool Suite.
 * @author Ade Hidayat
 * Email: ade.hidayat@axa.co.id
 * Date: Mar 22, 2021
 * Time: 11:09:11 AM
 */
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class ResponseSchema<T> extends ResponseBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T data;

}
