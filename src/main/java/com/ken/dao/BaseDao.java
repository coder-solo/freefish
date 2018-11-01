package com.ken.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * Define my own way to get Spring SqlMapClientTemplate instead of
 * using Spring SqlMapClientDaoSupport.
 * <p>Base on annotation or not. Prefer **annotation**.
 * 
 * @author Nen Den
 */
@SuppressWarnings("unchecked")
public abstract class BaseDao {

	/** iBatis template for querying. */
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	/**
	 * Template method for query a Simple Object.
	 * 
	 * @param sqlId
	 * @param param
	 * @return
	 */
	public <T> T get(String sqlId, Object param) {
		return (T) sqlMapClientTemplate.queryForObject(sqlId, param);
	}

	/**
	 * @see dn.cs.saber.dao.BaseDao#get(String sqlId, Object param)
	 */
	public <T> T get(String sqlId) {
		return get(sqlId, null);
	}

	/**
	 * Template method for query Objects.
	 * 
	 * @param sqlId
	 * @param param
	 * @return A list contains query result objects.
	 */
	public <T> List<T> getList(String sqlId, Object param) {
		return (List<T>) sqlMapClientTemplate.queryForList(sqlId, param);
	}

	/**
	 * @see dn.cs.saber.dao.BaseDao#getList(String sqlId, Object param)
	 */
	public <T> List<T> getList(String sqlId) {
		return getList(sqlId, null);
	}

	/**
	 * In current situation, narrow return Object to Integer.
	 * 
	 * @param sqlId
	 * @param param Use generic type.
	 * @return The primary key of the newly inserted row.
	 * 			Generated by the RDBMS automatically.
	 * @see com.ibatis.sqlmap.client.SqlMapExecutor#insert(String, Object)
	 */
	public <T> Integer add(String sqlId, T param) {
		Integer priKey = (Integer) sqlMapClientTemplate.insert(sqlId, param);
		return priKey;
	}

	/**
	 * Template method for update a Object.
	 * 
	 * @param sqlId
	 * @param param
	 */
	public void update(String sqlId, Object param) {
		sqlMapClientTemplate.update(sqlId, param);
	}

}