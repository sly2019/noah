package com.sly.noah.core.frontend.plugins;

import com.sly.noah.core.frontend.model.BaseTree;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Layui导航树模型
 * 
 * @author ninghaitao
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LayuiNavTree extends BaseTree<LayuiNavTree> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String pid;
	private String title;
	private String icon;
	private String href;
	private boolean spread;
	private List<LayuiNavTree> children = new ArrayList<LayuiNavTree>();

}
