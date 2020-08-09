# 탑
# 내 풀이
def solution(heights):
    answer = []

    while heights:
        count = 0
        print(heights)
        start = heights.pop()

        for i in range(len(heights)-1, -1, -1): # 3,2,1,0
            if start < heights[i]:
                answer.append(i+1)
                count +=1
                break
        if count == 0:
            answer.append(count)
  
    return answer[::-1]

print(solution([6,9,5,7,4]))