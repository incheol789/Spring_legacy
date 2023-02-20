package com.sh.spring.log;

import org.apache.log4j.Logger;

/**
 * LoggingFramework
 * - 모드별 출력가능
 * - 개발-운영 변경시, 모드만 변경해서 성능저하문제 해결
 * - log4j, logback, javt.util.logging, apache-commons-logging 등등
 * - slf4j 서비스계층역할을 할 의존을 중간에 끼워 스프링앱에서 사용.
 * 
 * 모드
 * - fatal 아주 심각한 오류
 * - error 프로그램 실행시 오류가 발생
 * - warn 현재 실행에는 문제가 없지만, 이후버젼에서는 변경될수 있는 잠재적 오류
 * - info 정보성 메세지
 * - debug 개발/디버그시 사용하는 로그
 * - trace debug를 세분화. 추적용으로 메소드의 시작/끝 등을 체크
 * 
 * 
 * - System.out.println()의 문제점.
 *  - 구분없이 출력되어 버려 서버 운영효율을 저하시킴.
 *  - 개발-운영 변경시 출력코드 수정하다 처리되는 코드도 주석되어 문제가 많이 발생
 * 
 *
 */
public class Log4jStudy {
	
	private static final Logger log = Logger.getLogger(Log4jStudy.class);

	public static void main(String[] args) {
		log.fatal("message - fatal");
		log.error("message - error");
		log.warn("message - warn");
		log.info("message - info");
		log.debug("message - debug");
		log.trace("message - trace");

	}

}
