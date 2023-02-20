package com.sh.spring.common.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * aop의 작동원리
 * - DI 받은 객체는 우리가 만든 클래스베이스의 객체가 아닌 스프링이 의도한 proxy객체이다.
 * - 인터페이스 구현클래스인 경우, jdk동적 proxy에서 생성한 객체가 주입.
 * - 인터페이스 구현클래스가 아닌 경우, cglib패키지에서 제공된 객체가 주입.
 *
 */

@Aspect
@Component
@Slf4j
public class LoggerAspect {
	
	/**
	 * Pointcut
	 * - 조인포인트 선정룰
	 * 
	 * 표현식 execution(* com.sh.spring.todo..*(..))
	 * - 모든 리턴타입
	 * - com.sh.spring.todo패키지 하위 모든 클래스의 모든 메소드
	 * - (..) 모든 매개변수 타입
	 */

	// 대상 메소드 선택
	@Pointcut("execution(* com.sh.spring.todo..*(..))")
	public void pointcut() {}
	
	
	/**
	 * Advice
	 * - 주 업무로직에 부가적으로 수행할 로직
	 * - 지정한 pointcut에 따라 특정 조인포인트에서 실행
	 * - 실행조건에 따라 before, around, after-returning, after, after-throwing 구
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("pointcut()") // 대상 실행 전후로 수행
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
		// joinPoint 정보 가져오기
		Signature signature = joinPoint.getSignature(); // com.sh.spring.app.controller.AppController.helloword()
		String type = signature.getDeclaringTypeName();
		// 메소드명
		String methodName = signature.getName();
		// before
		log.debug("[before] {}.{}", type, methodName);
		
		Object obj = joinPoint.proceed();
		// after
		log.debug("[after] {}.{}", type, methodName);
		
		return obj;
	}
}
