# [2,1,3,2] // 2 -> return 1
# 프린트
# 내 풀이
def sort_fun(print_list, max_value):
     while print_list[0][0] != max_value:
            tmp = print_list.pop(0)
            print_list.append(tmp)
     return print_list

def solution(priorities, location):
    answer = 0
    print_list = []
    answer_list = []
    # 마크
    for i in range(len(priorities)):
        if i == location:
            print_list.append([priorities[i],1])
        else:
            print_list.append([priorities[i],0])
        
    while print_list:
        max_value = print_list[0][0]
        for i in range(len(print_list)):
            if print_list[i][0] >= max_value:
                max_value = print_list[i][0]

        if print_list[0][0] != max_value:
            print_list2 = sort_fun(print_list,max_value)

        answer_list.append(print_list.pop(0))
   
    for i in range(len(answer_list)):
        if answer_list[i][1] == 1:
            answer = i+1
    return answer

#테스트 1 〉	통과 (0.48ms, 10.8MB)
#테스트 2 〉	통과 (0.43ms, 10.7MB)
#테스트 3 〉	통과 (0.38ms, 10.7MB)
#테스트 4 〉	통과 (0.13ms, 10.8MB)
#테스트 5 〉	통과 (0.04ms, 10.7MB)
#테스트 6 〉	통과 (0.13ms, 10.8MB)
#테스트 7 〉	통과 (0.17ms, 10.8MB)
#테스트 8 〉	통과 (0.37ms, 10.7MB)
#테스트 9 〉	통과 (0.05ms, 10.7MB)
#테스트 10 〉	통과 (0.12ms, 10.8MB)
#테스트 11 〉	통과 (0.25ms, 10.7MB)
#테스트 12 〉	통과 (0.11ms, 10.8MB)
#테스트 13 〉	통과 (0.30ms, 10.7MB)
#테스트 14 〉	통과 (0.04ms, 10.9MB)
#테스트 15 〉	통과 (0.09ms, 10.9MB)
#테스트 16 〉	통과 (0.07ms, 10.7MB)
#테스트 17 〉	통과 (0.40ms, 10.7MB)
#테스트 18 〉	통과 (0.05ms, 10.8MB)
#테스트 19 〉	통과 (0.37ms, 10.7MB)
#테스트 20 〉	통과 (0.23ms, 10.7MB)

#print(solution([4,3,5,2], 3))
#print(solution([2,1,3,2], 2))
from collections import deque
# 다른 사람 풀이
def solution_2(priorities, location):
    temp_queue = [(i,p) for i,p in enumerate(priorities)]
    queue = deque(temp_queue)
    #print('queue 1 : ' , queue)
    answer = 0
    while True:
        cur = queue.popleft()
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            #print('queue 3 : ' , queue)
            answer += 1 # 프린터한 갯수
            if cur[0] == location:
                return answer

        #print('queue 2 : ' , queue)

#테스트 1 〉	통과 (0.36ms, 10.7MB)
#테스트 2 〉	통과 (0.77ms, 10.8MB)
#테스트 3 〉	통과 (0.11ms, 10.7MB)
#테스트 4 〉	통과 (0.13ms, 10.8MB)
#테스트 5 〉	통과 (0.05ms, 10.7MB)
#테스트 6 〉	통과 (0.14ms, 10.7MB)
#테스트 7 〉	통과 (0.14ms, 10.8MB)
#테스트 8 〉	통과 (0.54ms, 10.7MB)
#테스트 9 〉	통과 (0.07ms, 10.6MB)
#테스트 10 〉	통과 (0.16ms, 10.7MB)
#테스트 11 〉	통과 (0.45ms, 10.6MB)
#테스트 12 〉	통과 (0.08ms, 10.7MB)
#테스트 13 〉	통과 (0.37ms, 10.7MB)
#테스트 14 〉	통과 (0.04ms, 10.7MB)
#테스트 15 〉	통과 (0.06ms, 10.7MB)
#테스트 16 〉	통과 (0.09ms, 10.6MB)
#테스트 17 〉	통과 (0.50ms, 10.7MB)
#테스트 18 〉	통과 (0.07ms, 10.8MB)
#테스트 19 〉	통과 (0.45ms, 10.6MB)
#테스트 20 〉	통과 (0.12ms, 10.7MB)
print(solution_2([4,3,5,2], 3))   
print(solution_2([2,1,3,2], 2))    