SELECT 
SYSDATE + 100, --현재날짜 +100일
SYSDATE - 100, --현재날짜 -100일
SYSTIMESTAMP + 100, --현재날짜 +100일
SYSTIMESTAMP - 100 --현재날짜 -100일
FROM
DUAL;

SELECT 
ADD_MONTHS(SYSDATE,6), --현재시간 + 6개월 뒤
LAST_DAY(SYSDATE), --해당월 마지막 일자 계산
NEXT_DAY(SYSDATE,'일요일'), --다음 주 일요일 계산
MONTHS_BETWEEN(SYSDATE, SYSDATE-100) --DATE1과 DATE2의 개월 수 반환
FROM
DUAL;

SELECT
TO_CHAR(SYSDATE ,'yyyy/mm/dd'), --오늘 날짜  
TO_CHAR(SYSDATE + 1 ,'yyyy/mm/dd'), --내일 날짜  
TO_CHAR(SYSDATE -1 ,'yyyy/mm/dd'), --어제 날짜  
TO_CHAR(TRUNC(SYSDATE,'dd') ,'yyyy/mm/dd hh24:mi:ss'), -- 오늘 정각 날짜
TO_CHAR(TRUNC(SYSDATE,'dd') + 1,'yyyy/mm/dd hh24:mi:ss'), -- 내일 정각 날짜
TO_CHAR(SYSDATE + 1/24/60/60 ,'yyyy/mm/dd hh24:mi:ss'), -- 1초 뒤 시간
TO_CHAR(SYSDATE + 1/24/60 ,'yyyy/mm/dd hh24:mi:ss'), -- 1분 뒤 시간
TO_CHAR(SYSDATE + 1/24 ,'yyyy/mm/dd hh24:mi:ss'), -- 1일 뒤 시간
TO_CHAR(TRUNC(SYSDATE,'mm') ,'yyyy/mm/dd'), --이번 달 시작날짜
TO_CHAR(LAST_DAY(SYSDATE) ,'yyyy/mm/dd'), --이번 달 마지막 날
TO_CHAR(trunc(ADD_MONTHS(SYSDATE, + 1),'mm') ,'yyyy/mm/dd'), --다음 달 시작날짜
TO_CHAR(ADD_MONTHS(SYSDATE, 1) ,'yyyy/mm/dd hh24:mi:ss'), -- 다음달 오늘 날자
TO_CHAR(TRUNC(SYSDATE, 'yyyy') ,'yyyy/mm/dd'), --올해 시작 일
TO_CHAR(TRUNC(ADD_MONTHS(SYSDATE, -12), 'dd'),'yyyy/mm/dd'), --작년 현재 일
TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE('19930315'), -- 두 날짜 사이 일수 계산
MONTHS_BETWEEN(SYSDATE, '19930315'), -- 두 날짜 사이의 월수 계산
TRUNC(MONTHS_BETWEEN(SYSDATE, '19930315')/12,0) --두 날짜 사이의 년수 계산
FROM
DUAL; 