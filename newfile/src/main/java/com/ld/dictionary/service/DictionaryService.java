package com.ld.dictionary.service;

import com.ld.dictionary.bean.Dictionary;

/**
 * 字典service
 * @author lvdong
 *
 */
public interface DictionaryService {
	/**
	 * 保存字典方法
	 */
	public void saveDictionary(Dictionary dict) ;
	/**
	 * 批量保存字典,导入使用
	 */
	public void batchSave();
	/**
	 * 删除单个
	 */
	public void delete();
	/**
	 * 多个删除
	 */
	public void deleteMore();
	/**
	 * 查询所有,放到redis中，下次查询直接调用redis，如有增删改，更新redis中的值
	 */
	public void allDictionary();
}
