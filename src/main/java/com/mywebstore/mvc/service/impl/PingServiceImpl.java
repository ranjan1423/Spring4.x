package com.mywebstore.mvc.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywebstore.mvc.dao.PingDao;
import com.mywebstore.mvc.service.PingService;

@Service
public class PingServiceImpl implements PingService {

	private static final Logger LOGGER = Logger.getLogger(PingServiceImpl.class);

	@Autowired
	private PingDao pingDao;

	@Override
	public String checkDb() {
		StringBuilder message = new StringBuilder();
		try {
			message.append(pingDao.checkDb());
		} catch (Exception exp) {
			LOGGER.error("Exception in PingServiceImpl : " + exp.getMessage());
		}
		return message.toString();
	}
}
