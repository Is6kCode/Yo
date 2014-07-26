package org.yo.dao.jdbc.impl;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.yo.beans.ID;

public class JdbsSupport extends NamedParameterJdbcDaoSupport {
	@Autowired
	public void init(@Qualifier("dataSource") DataSource dataSource) {
		setDataSource(dataSource);
	}
	/**
	 * 返回表的主键
	 * @param sql
	 * @param object
	 * @return
	 */
	public int updateForBean(String sql, Object object) {
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		int ret =  getNamedParameterJdbcTemplate().update(sql,
				new BeanPropertySqlParameterSource(object),keyHolder);
		if (object instanceof ID
				&&  keyHolder.getKey() != null
				&& keyHolder.getKey().longValue() > 0) {
			((ID)object).setID( keyHolder.getKey().longValue());
		}
		return ret;
	}
}
