package com.sh.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * slf4j
 * - Simple Logging Facade for java
 * - PSA 예시
 * - slf4j를 통해서 구체화된 logging 의존을 제어함.
 * 
 *
 */
public class Slf4jStudy {
	
	private static final Logger log = LoggerFactory.getLogger(Slf4jStudy.class);

	public static void main(String[] args) {
//		log.fatal("message - fatal"); // slf4j에는 fatal 레벨이 없다.
		log.error("message - error");
		log.warn("message - warn");
		log.info("message - info");
		log.debug("message - debug");
		log.trace("message - trace");

	}

}
