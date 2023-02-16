package com.sh.spring.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.spring.demo.model.dto.Dev;

@Mapper // -> 이거 선언하면 이 클래스 삭제해도 된다..
public interface DemoDao {

	int insertDev(Dev dev);

	List<Dev> selectDevList();

	Dev selectDevOne(int no);

	int updateDev(Dev dev);



}
