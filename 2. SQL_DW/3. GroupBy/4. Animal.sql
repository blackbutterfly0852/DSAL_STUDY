-- 입양 시각 구하기(2)

with tmp as (
select '00' time from dual
union all
select '01' time from dual
union all  
select '02' time from dual
union all
select '03' time from dual
union all  
select '04' time from dual
union all
select '05' time from dual
union all  
select '06' time from dual
union all
select '07' time from dual
union all  
select '08' time from dual
union all
select '09' time from dual
union all  
select '10' time from dual
union all
select '11' time from dual
union all  
select '12' time from dual
union all
select '13' time from dual
union all  
select '14' time from dual
union all
select '15' time from dual
union all 
select '16' time from dual
union all
select '17' time from dual
union all 
select '18' time from dual
union all
select '19' time from dual
union all  
select '20' time from dual
union all
select '21' time from dual
union all
select '22' time from dual
union all
select '23' time from dual
)

select to_number(t1.time) HOUR, decode(t2.cnt, null, 0, t2.cnt) cnt from 

(select time from tmp ) t1,

(
select  time , count(time) cnt from (
select to_char(a1.datetime, 'HH24') time, a1.* from ANIMAL_OUTS a1)
group by time
) t2
where t1.time = t2.time(+)
order by t1.time;



SELECT H.HOUR, NVL(A.COUNT, 0) AS COUNT
FROM (SELECT level-1 AS "HOUR"
      FROM DUAL
      CONNECT BY level < 25) H
LEFT OUTER JOIN      
      (SELECT to_char(DATETIME, 'HH24') AS "HOUR", COUNT(ANIMAL_ID) AS "COUNT"
       FROM ANIMAL_OUTS
       GROUP BY to_char(DATETIME, 'HH24')) A
ON (H.HOUR = A.HOUR)
ORDER BY H.HOUR;

