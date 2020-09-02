/* 3. 오랜기간 보호한 동물 */

select * from (
select a1.name, a1.datetime from ANIMAL_INS a1
where  a1.animal_id not in (select a2.animal_id from ANIMAL_OUTS a2 ) 
order by a1.datetime) 
where rownum <=3; /* 정렬 후, rownum 진행 */

select * from (
select a1.name, a1.datetime from ANIMAL_INS a1
where  not exists (select * from ANIMAL_OUTS a2 where a2.animal_id = a1.animal_id) /* not exsit : 서브쿼리에 존재하지 않는 데이터 반환 */
order by a1.datetime)
where rownum <=3;

/*  
 IN은 서브쿼리 결과를 모두 수행하고, EXISTS는 일치하는 결과가 있으면 더 이상 수행하지 않는다. 
 서브 쿼리 테이블(dept_history)에 데이터량이 많으면 EXISTS를 사용하는것이 성능이 좋다. 
 EXISTS의 서브 쿼리를 메인 쿼리 JOIN으로 변경할 경우 위와 같이 중복된 데이터 나올 수 있으니 주의해야 한다.
 JOIN을 사용하는것이 성능상 좋을 수 있으나 메인 쿼리와 서브 쿼리의 데이터가 1:1일 경우 가능하다. 
 */



