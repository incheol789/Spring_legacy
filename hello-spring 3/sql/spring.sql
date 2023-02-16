--===============================
-- 관리자계정
--===============================
-- spring계정 생성
alter session set "_oracle_script" = true;

create user spring identified by spring
default tablespace users;

alter user spring quota unlimited on users;

grant connect, resource to spring;



--===============================
-- spring계정
--===============================
-- drop table dev
-- drop sequence seq_dev_no;

-- dev테이블 생성
create table dev(
    no number,
    name varchar2(50) not null,
    career number not null,
    email varchar2(200) not null,
    gender char(1),
    lang varchar2(100) not null,
    created_at date default sysdate,
    constraint pk_dev_no primary key(no),
    constraint ch_dev_gender check(gender in ('M', 'F'))
);
create sequence seq_dev_no;

select * from dev;

-- 회원 테이블
create table member (
    member_id varchar2(50),
    password varchar2(300) not null,
    name varchar2(256) not null,
    birthday date,
    email varchar2(256),
    phone char(11) not null,
    created_at date default sysdate,
    enabled number default 1,
    constraint pk_member_id primary key(member_id),
    constraint ck_member_enabled check(enabled in (1, 0))
);
insert into spring.member values ('abcde','1234','아무개',to_date('88-01-25','rr-mm-dd'),'abcde@naver.com','01012345678', default, default);
insert into spring.member values ('qwerty','1234','김말년',to_date('78-02-25','rr-mm-dd'),'qwerty@naver.com','01098765432', default, default);
insert into spring.member values	('admin','1234','관리자',to_date('90-12-25','rr-mm-dd'),'admin@naver.com','01012345678', default, default);
commit;

select * from member;










