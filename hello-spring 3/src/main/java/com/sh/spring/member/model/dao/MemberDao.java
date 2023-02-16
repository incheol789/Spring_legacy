package com.sh.spring.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sh.spring.member.model.dto.Member;


/**
 * 
 * 1. mapper.xml로 연결
 * 2. 추상메소드에 @Insert @update @delete @select를 통해 간단한 쿼리 직접 작성
 *
 */
@Mapper
public interface MemberDao {

	int insertMember(Member member);

}
