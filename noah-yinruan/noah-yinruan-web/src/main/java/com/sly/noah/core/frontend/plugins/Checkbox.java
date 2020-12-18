package com.sly.noah.core.frontend.plugins;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 复选框
 *
 */
@Data
public class Checkbox implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private Boolean checked;

}
