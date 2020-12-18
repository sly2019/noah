package com.sly.noah.core.frontend.plugins;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * EasyUI树模型
 * 
 * @author ninghaitao
 *
 */
@Data
public class EasyUITree implements Serializable {

	private static final long serialVersionUID = 980682543891282923L;

	private String id;// 树节点ID
	private String text;// 树节点名称
	private String iconCls;// 树节点图标
	private boolean checked = false;// 是否加载复选框
	private String state = "open";// 树节点状态：打开open；关闭closed
	private Object attributes;// 自定义属性
	private Object target;// 目标

	private String pid;// 父节点
	private List<EasyUITree> children;// 子节点

	public void setState(boolean isOpen) {
		this.state = isOpen ? "open" : "closed";
	}

}
