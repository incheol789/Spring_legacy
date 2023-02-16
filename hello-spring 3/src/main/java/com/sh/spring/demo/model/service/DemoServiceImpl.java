package com.sh.spring.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.spring.demo.model.dao.DemoDao;
import com.sh.spring.demo.model.dto.Dev;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoDao demoDao;

	/**
	 * 트랜잭션처리, SqlSession생성 및 반환 모두 생략
	 */
	@Override
	public int insertDev(Dev dev) {
		return demoDao.insertDev(dev);
	}
	
	@Override
	public List<Dev> selectDevList() {
		return demoDao.selectDevList();
	}

	@Override
	public Dev selectDevOne(int no) {
		return demoDao.selectDevOne(no);
	}

	@Override
	public int updateDev(Dev dev) {
		return demoDao.updateDev(dev);
	}




}
