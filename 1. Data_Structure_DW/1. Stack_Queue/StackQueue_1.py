## 다리를 지나는 트럭
# 2, 10, [7,4,5,6]
# sum()
def solution(bridge_length, weight, truck_weights):
    answer = 0
    tmp_truck = truck_weights[::-1]
    tmp_bridge = [0] * bridge_length
    sum_total = sum(tmp_bridge) ## 0
    while tmp_bridge:
        answer +=1
        sum_tmp = tmp_bridge.pop(0)
        sum_total -= sum_tmp ## 0
        if tmp_truck:
            if (sum_total + tmp_truck[-1]) <= weight:
                sum_total += tmp_truck[-1]
                tmp_bridge.append(tmp_truck.pop())
            else :
                tmp_bridge.append(0)
            
    return answer


print(solution(2, 10, [7,4,5,6]))
#print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))
print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))

# 서진원
def solution(bridge_length, weight, truck_weights):
    answer = 0 
    bridge_list = [0] * bridge_length
    while bridge_list :
        answer += 1 
        bridge_list.pop(0) 
        if truck_weights :
            if sum(bridge_list) + truck_weights[0] <= weight :
                bridge_list.append(truck_weights.pop(0))
            else :
                bridge_list.append(0)

    return answer 