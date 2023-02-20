package com.sh.spring.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.spring.demo.model.dto.Dev;

@Mapper
public interface DemoDao {

	int insertDev(Dev dev);

	List<Dev> selectDevList();
	
	Dev selectOneDev(int no);

	int updateDev(Dev dev);

}
