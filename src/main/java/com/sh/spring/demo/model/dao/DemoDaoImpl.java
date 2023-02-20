package com.sh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sh.spring.demo.model.dto.Dev;

@Repository
public class DemoDaoImpl implements DemoDao {
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int insertDev(Dev dev) {
		return session.insert("demo.insertDev", dev);
	}
	
	@Override
	public List<Dev> selectDevList() {
		return session.selectList("demo.selectDevList");
	}

	@Override
	public Dev selectOneDev(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDev(Dev dev) {
		// TODO Auto-generated method stub
		return 0;
	}
}
