package com.sly.noah.core.frontend.helper;

import com.sly.noah.core.frontend.model.BaseTree;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TreeVOHelper<T extends BaseTree> {

	private TreeVOHelper() {
	}

	private static TreeVOHelper treeVOHelper;

	static {
		treeVOHelper = new TreeVOHelper();
	}

	public synchronized static TreeVOHelper getInstance() {
		if (treeVOHelper == null) {
			treeVOHelper = new TreeVOHelper();
		}
		return treeVOHelper;
	}

	/**
	 * 平滑处理树节点数据
	 * 
	 * @param rawTreeDatas
	 *            pid模式的数据
	 * @description 将pid模式改为children模式
	 * @return children模式的数据
	 */
	public List<T> convertTreeModeFromPidToChildren(List<T> rawTreeDatas) {
		Map<String, T> idVsTreeVO = new LinkedHashMap<String, T>();
		for (T rawTreeData : rawTreeDatas) {
			idVsTreeVO.put(rawTreeData.getId(), rawTreeData);
		}
		return convertTreeModeFromPidToChildren(idVsTreeVO);
	}

	/**
	 * 平滑处理树节点数据
	 * 
	 * @param idVsTreeVO
	 *            pid模式的数据
	 * @description 将pid模式改为children模式
	 * @return children模式的数据
	 */
	public List<T> convertTreeModeFromPidToChildren(Map<String, T> idVsTreeVO) {
		List<T> treeData = new ArrayList<T>();
		for (Entry<String, T> idVsTreeVOEntry : idVsTreeVO.entrySet()) {
			T treeVO = idVsTreeVOEntry.getValue();
			String id = treeVO.getId();
			String pid = treeVO.getPid();
			T treeVOParent = idVsTreeVO.get(pid);
			if (treeVOParent != null && !id.equals(pid)) {
				List<T> children = treeVOParent.getChildren();
				if (CollectionUtils.isEmpty(children)) {
					children = new ArrayList<T>();
				}
				children.add(treeVO);
				treeVOParent.setChildren(children);
			} else {
				treeData.add(treeVO);
			}
		}
		return treeData;
	}

}
