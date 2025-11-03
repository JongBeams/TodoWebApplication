
/*
sql 파일 생성 시 실행 후 자동으로 해당 파일 실행
sql 파일은 기본적으로 entity에서 테이블 초기화 전에 실행되니
spring.jpa.defer-datasource-initialization=true로
데이터 초기화 순서를 조정하는 설정 바꿔서 테이블 생성
*/
insert into todo (ID,USERNAME,DESCRIPTION,TARGET_DATE,DONE)
values (10001,'jongbeom','일정짜기ㅣ기기기기기기','2025-11-10',false);
insert into todo (ID,USERNAME,DESCRIPTION,TARGET_DATE,DONE)
values (10002,'jongbeom','놀고싶다아아아아아아아','2026-02-10',false);
insert into todo (ID,USERNAME,DESCRIPTION,TARGET_DATE,DONE)
values (10003,'jongbeom','일정이 빡빡해에에에ㅔㅇ에ㅔ','2026-01-10',false);
insert into todo (ID,USERNAME,DESCRIPTION,TARGET_DATE,DONE)
values (10004,'jongbeom','개발조아아아아아아아아',CURRENT_DATE(),false);
