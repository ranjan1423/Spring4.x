package com.mywebstore.mvc.dao.impl.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

public class NowMapper implements RowMapper<String> {

	private static final Logger LOGGER = Logger.getLogger(NowMapper.class);

	public String mapRow(ResultSet resultSet, int i) throws SQLException {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(resultSet.getString("now()"));
		} catch (Exception exp) {
			LOGGER.error("Exception in NowMapper : " + exp.getMessage());
		}
		return sb.toString();
	}
}