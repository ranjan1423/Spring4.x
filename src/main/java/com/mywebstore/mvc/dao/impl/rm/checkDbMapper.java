package com.mywebstore.mvc.dao.impl.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

public class checkDbMapper implements RowMapper<String> {

	private static final Logger LOGGER = Logger.getLogger(checkDbMapper.class);

	public String mapRow(ResultSet resultSet, int i) throws SQLException {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(resultSet.getString("now()"));
		} catch (Exception exp) {
			LOGGER.error("Exception in checkDbMapper : " + exp.getMessage());
		}
		return sb.toString();
	}
}