package com.mywebstore.mvc.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mywebstore.mvc.dao.PingDao;
import com.mywebstore.mvc.dao.impl.rm.checkDbMapper;

@Repository
public class PingDaoImpl implements PingDao {

	private static final Logger LOGGER = Logger.getLogger(PingDaoImpl.class);

	private final String SQL_NOW = "SELECT now();";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public String checkDb() {
		String result = null;
		try {
			result = jdbcTemplate.queryForObject(SQL_NOW, new Object[] {}, new checkDbMapper());
		} catch (Exception exp) {
			LOGGER.error("Exception in PingDaoImpl : " + exp.getMessage());
		}
		return result.toString();
	}
}
