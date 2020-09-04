-- 오랜 기간 보호한 동물(2)
SELECT id, name FROM (
SELECT a1.animal_id id, a1.name name,  a1.datetime - a2.datetime
FROM ANIMAL_OUTS a1 inner join ANIMAL_INS a2 on (a1.animal_id = a2.animal_id)
--where a1.animal_id in ('A362707','A370507' )
order by  a1.datetime - a2.datetime desc)
where rownum <=2;
