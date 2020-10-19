# 주식가격
# 내 풀이
def solution(prices):
    tmp_p = prices[::-1]
    #print('prices : ', prices)
    answer = []

    while tmp_p:
        start = tmp_p.pop()
        tmp_answer = 0
        if tmp_p:
            for i in range(len(tmp_p)-1,-1,-1):
                #print('i : ', i)
                if start  <= tmp_p[i] :
                    tmp_answer+=1
                else:
                    tmp_answer+=1
                    break
        
        answer.append(tmp_answer)    

    return answer

#테스트 1 〉	통과 (108.07ms, 140MB)
#테스트 2 〉	통과 (88.36ms, 105MB)
#테스트 3 〉	통과 (150.31ms, 158MB)
#테스트 4 〉	통과 (101.79ms, 121MB)
#테스트 5 〉	통과 (68.51ms, 87.6MB)    
    
# 다른사람 풀이 1
def solution_2(prices):
    answer = [0] * len(prices)

    for i in range(len(prices)):
        for j in range(i+1, len(prices)):
            if(prices[i] <= prices[j]):
                answer[i]+=1
            else:
                answer[i]+=1
                break
    return answer

#테스트 1 〉	통과 (152.02ms, 141MB)
#테스트 2 〉	통과 (118.16ms, 105MB)
#테스트 3 〉	통과 (193.31ms, 157MB)
#테스트 4 〉	통과 (126.58ms, 121MB)
#테스트 5 〉	통과 (90.54ms, 87.5MB)    

#print(solution_2([1,2,3,2,3]))

# 다른사람 풀이 2
def solution_3(p): # [1,2,3,2,3]
    print('p : ', p)
    ans = [0] * len(p)
    stack = [0] # 주식가격이 처음으로 떨어지는 지점을 못찾은 가격의 index
    # 1. 주식가격이 처음으로 떨어지는 지점을 못찾은 가격의 index 구하기
    for i in range(1, len(p)):
        print('p[i] < p[stack[-1]] : ', i, stack[-1])
        if p[i] < p[stack[-1]]: # p[1] 2 < p[0] 1 ? -> p[2] 3 < p[1] 2 ? -> p[3] 2 < p[2] 3                     -> p[4] 3 < p[3] 3
            for j in stack[::-1]:                                         # stack = [2,1,0]
                if p[i] < p[j]:                                           # p[3] 2 < p[2] 3 -> p[3] 2 < p[1] 2
                    ans[j] = i-j                                          # ans[2] = 3-2 = 1
                    stack.remove(j)                                       # stack = [0,1]
                else:
                    break                                                                     # break
        stack.append(i) # stack = [0,1,2]                                 # stack = [0,1,3]                      -> stack = [0,1,3,4]
        print('stack : ', stack)
    
    
    
    # 위의 1의 못찾은 지점만 가져와 각 ans 계산. stack = [0,1,3,4]
    for i in range(0, len(stack)-1): # i = 0 ~ 3
        ans[stack[i]] = len(p) - stack[i] - 1 # ans[0] = 5-0-1=4 -> ans[1] = 5-1-1=3 -> ans[3] = 5-3-1 = 1 -> ans[4] = 5-4-1 = 0
    return ans

#print(solution_3([1,2,3,2,3]))

#print(solution_3([1,3,3,2,3]))

# 마지막 solution 1 vs solution 3 복습





    


    


print(solution_4([1,2,3,2,3]))

    
        


    