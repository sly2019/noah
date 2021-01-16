package com.sly.noah.core.frontend.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class BaseTree<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String pid;
	private String name;
	private String code;
	private String description;
	private List<T> children = new ArrayList<T>();

}
