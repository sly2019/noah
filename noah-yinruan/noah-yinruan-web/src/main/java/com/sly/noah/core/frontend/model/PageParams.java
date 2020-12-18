package com.sly.noah.core.frontend.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 基础页面参数
 * 
 * @author ninghaitao
 *
 */
@Getter
@Setter
public class PageParams {

	/**
	 * 数据列表当前页
	 */
	Integer page;

	/**
	 * 数据列表总行数
	 */
	Integer limit;

	/**
	 * 数据列表总行数
	 */
	Integer rows;

	/**
	 * 需要排序的属性名，支持多个。例：'orderNum|createTime'
	 */
	String sort;

	/**
	 * 排序属性对应的排序方式：asc、desc，支持多个，必须与`sort`的属性数量一致才能生效。例：'asc|desc'
	 */
	String order;

}
