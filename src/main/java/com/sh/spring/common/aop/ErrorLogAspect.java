package com.sh.spring.common.aop;

import javax.sql.rowset.Joinable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ErrorLogAspect {
	
	@Pointcut("execution(* com.sh.spring..*Controller.*(..))")
	public void pc() {}
	
	@AfterThrowing(pointcut = "pc()", throwing = "e")
	public void errorLog(JoinPoint joinPoint, Exception e) {
		log.error(e.getMessage(), e);
	}
}
