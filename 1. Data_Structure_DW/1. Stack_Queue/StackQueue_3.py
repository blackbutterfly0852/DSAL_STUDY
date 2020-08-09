# 기능개발
# [93,30,55] // [1,30,5] // [2,1]
# 내 풀이
def solution(progresses, speeds):
    answer = []
    tmp_answer = []
    # 1. 각 작업당 작업일수 계산
    for i in range(len(progresses)):
        workday_remain = (100 - progresses[i]) % speeds[i]
        workday_value = (100 - progresses[i]) // speeds[i]
        if workday_remain == 0:
            tmp_answer.append(workday_value)
        else:
            tmp_answer.append(workday_value+1)

    # 2. 위의 1에서 구해진 작업일수 기준으로 각 작업 완료당 배포개수 구한다.
    while tmp_answer:
        # 2-1. 앞에서 순차적으로 pop
        start = tmp_answer.pop(0)
        # 2-2. 최소배포 개수 1
        count = 1
        # 2-3. 배포작업을 기준으로 순차적으로 조건검사
        for i in range(len(tmp_answer)):
            if start >= tmp_answer[i]:
                count+=1
            else:
                break
        #print('count : ', count)
        # 2-4. 동시 배포 개수 append
        answer.append(count)    
        # 2-4. 동시 배포 개수 - 1 만큼 제외
        for _ in range(count-1):
            tmp_answer.pop(0)
                       
    return answer

#print(solution([93,30,55], [1,30,5]))

#테스트 1 〉	통과 (0.04ms, 10.7MB)
#테스트 2 〉	통과 (0.08ms, 10.8MB)
#테스트 3 〉	통과 (0.07ms, 10.7MB)
#테스트 4 〉	통과 (0.06ms, 10.7MB)
#테스트 5 〉	통과 (0.04ms, 10.8MB)
#테스트 6 〉	통과 (0.06ms, 10.8MB)
#테스트 7 〉	통과 (0.07ms, 10.9MB)
#테스트 8 〉	통과 (0.05ms, 10.8MB)
#테스트 9 〉	통과 (0.06ms, 10.9MB)
#테스트 10 〉	통과 (0.08ms, 10.8MB)
#테스트 11 〉	통과 (0.05ms, 10.9MB)

# 2. Python 함수 활용법
# [93,30,55] // [1,30,5] // [2,1]
# ZIP 함수
a = "YUN"
b = [1, 2, 3]
c = ("하나", "둘", "셋")
#print(list(zip(a, b, c))) # [(‘Y’, 1, ‘하나’), (‘U’, 2, ‘둘’), (‘N’, 3, ‘셋’)]
#print(set(zip(a, b, c))) # {(‘Y’, 1, ‘하나’), (‘N’, 3, ‘셋’), (‘U’, 2, ‘둘’)}
#print(dict(zip(a, b))) # {‘Y’: 1, ‘U’: 2, ‘N’: 3}

# 다른 사람 풀이
def solution_2(progresses, speeds):
    Q=[]
    print('Q , ', Q)
    # 생각 : 2.3이든 2.6이든 3을 별도로 구하지 않고, 기준작업일수보다 작으면 같이 배포.
    for p, s in zip(progresses, speeds):
        if len(Q)==0 or Q[-1][0]< -((p-100)//s):
            Q.append([-((p-100)//s),1])
            print('Q[-1][0] 1 , ', Q[-1][0])
        else:
            Q[-1][1]+=1
        print('Q[-1][0] 2 , ', Q[-1][0])
    return [q[1] for q in Q]

#print(solution_2([93,30,55], [1,30,5]))

#print((30-100)//30)
#print((100-30)//30)
#print(-70//3)


# 3. 다른 사람 풀이
# [93,30,55] // [1,30,5] // [2,1]
def solution_3(progresses, speeds):
    print(progresses)
    print(speeds)
    answer = []
    time = 0
    count = 0
    while progresses:
        print('count : ', count)
        if (progresses[0] + time*speeds[0]) >= 100:
            print('time : ', time)
            print('sum : ', progresses[0] + time*speeds[0] )
            progresses.pop(0)
            speeds.pop(0)
            count += 1
        else:
            if count > 0:
                answer.append(count)
                count = 0
            time += 1
    print('answer : ', answer)
    answer.append(count)
    return answer

print(solution_3([93,30,55], [1,30,5]))