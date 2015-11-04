package com.witsafe.service.security;

import java.util.Collections;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witsafe.dao.ConfDictionaryMapper;
import com.witsafe.framework.orm.Page;
import com.witsafe.framework.orm.PropertyFilter;
import com.witsafe.model.ConfDictionary;

/**
 * 配置字典管理类
 * @author yuqs
 * @since 0.1
 */
@Component
public class DictionaryManager {
	@Autowired
	private ConfDictionaryMapper confDictionaryMapper;
	
	/**
	 * 保存配置字典实体
	 * @param entity
	 */
	public void save(ConfDictionary entity) {
		confDictionaryMapper.updateByPrimaryKey(entity);
	}
	
	

	/**
	 * 根据字典名称，获取配置字典数据对象
	 * @param name
	 * @return Map<String, String> 选项主键ID、选项名称的字典映射集合
	 */
	public Map<String, String> getByName(String name) {
		//List<DictionaryItem> items = getItemsByName(name);
		//if(items == null || items.isEmpty()) return Collections.emptyMap();
		Map<String, String> dicts = new TreeMap<String, String>();
		
		return dicts;
	}
}
