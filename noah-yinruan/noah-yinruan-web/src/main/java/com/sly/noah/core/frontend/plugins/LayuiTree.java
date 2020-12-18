package com.sly.noah.core.frontend.plugins;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Layui树模型
 * 
 * @author ninghaitao
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LayuiTree extends BaseTree<LayuiTree> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String pid;
	private String name;
	private String code;
	private String description;
	private String icon;
	private String href;
	private boolean spread;
	private List<LayuiTree> children = new ArrayList<LayuiTree>();

}
