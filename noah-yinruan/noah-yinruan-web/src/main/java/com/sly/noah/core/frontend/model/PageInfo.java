package com.sly.noah.core.frontend.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页信息
 */
@Getter
@Setter
public class PageInfo {

	/**
	 * 分页对象
	 */
	private Pageable pageable;// 分页对象

	/**
	 * 数据总数
	 */
	private int total;
	private int count;

	/**
	 * 数据列表
	 */
	private List rows;
	private List data;

	/**
	 * 数据状态
	 */
	private int code;

	/**
	 * 状态信息
	 */
	private String msg;

	public PageInfo() {

	}

	public PageInfo(PageParams pageParams) {

		int page = buildPage(pageParams);
		int size = buildSize(pageParams);

		List<Order> orders = buildSort(pageParams);
		Sort sort = null;
		if (CollectionUtils.isNotEmpty(orders)) {
			sort = Sort.by(orders);
		}

		Pageable pageable = PageRequest.of(page, size, sort);

		this.pageable = pageable;
	}

	private int buildSize(PageParams pageParams) {
		int size = 0;
		if (pageParams.getRows() != null && pageParams.getRows() >= 0) {
			size = pageParams.getRows();
		} else if (pageParams.getLimit() != null && pageParams.getLimit() >= 0) {
			size = pageParams.getLimit();
		}
		return size;
	}

	private int buildPage(PageParams pageParams) {
		int page = 0;
		if (pageParams.getPage() != null && pageParams.getPage() >= 0) {
			page = pageParams.getPage() - 1;
		}
		return page;
	}

	private List<Order> buildSort(PageParams pageParams) {
		List<Order> orders = new ArrayList<Order>();
		if (StringUtils.isNotBlank(pageParams.getSort()) && StringUtils.isNotBlank(pageParams.getOrder())) {
			String[] sortSplit = StringUtils.split(pageParams.getSort(), "|");
			String[] orderSplit = StringUtils.split(pageParams.getOrder(), "|");
			if (sortSplit.length == orderSplit.length) {
				for (int i = 0; i < sortSplit.length; i++) {
					String sort = sortSplit[i];
					String orderDirection = orderSplit[i];
					Direction direction = getOrderDirection(orderDirection);
					Order order = new Order(direction, sort);
					orders.add(order);
				}
			}
		}
		return orders;
	}

	private Direction getOrderDirection(String order) {
		Direction direction = Direction.ASC;
		if (StringUtils.isNotBlank(order)) {
			if (StringUtils.equalsIgnoreCase(order, "asc")) {
				direction = Direction.ASC;
			} else if (StringUtils.equalsIgnoreCase(order, "desc")) {
				direction = Direction.DESC;
			}
		}
		return direction;
	}

}
