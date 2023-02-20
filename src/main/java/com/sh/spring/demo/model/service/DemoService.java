package com.sh.spring.demo.model.service;

import java.util.List;

import com.sh.spring.demo.model.dto.Dev;

public interface DemoService {

	int insertDev(Dev dev);

	List<Dev> selectDevList();
	
	Dev selectOneDev(int no);

	int updateDev(Dev dev);

}
