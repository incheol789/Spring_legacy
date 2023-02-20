package com.sh.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class StopWatchAspect {
	
	// 커스텀 어노테이션 
	@Pointcut("@annotation(com.sh.spring.common.annotation.RunnigTime)") 
	private void enableRunnigTime() {}
	
	// 기본 패키지의 모든 메소드
	@Pointcut("execution(* com.sh.spring..*.*(..))")
	public void pointcut() {}
	
	// 실행 시점 설정 : 두 조건을 모두 만족하는 대상을 전후로 부가 기능 삽입
	@Around("pointcut() && enableRunnigTime()")
	public void loggingRunningTime(ProceedingJoinPoint joinPoint) throws Throwable {
		// 메소드 수행 전, 측정 시작
		StopWatch stopWatch =  new StopWatch();
		stopWatch.start();
		
		// 메소드 수행
		Object returningObj = joinPoint.proceed();
		
		// 메소드 수행 후, 측정 종료 및 로깅  
		stopWatch.stop();
		
		// 메소드명
		String methodName = joinPoint.getSignature()
				.getName();
		
		log.info("{}의 총 수행 시간 => {} sec", stopWatch.getTotalTimeSeconds());
		
	}

}
