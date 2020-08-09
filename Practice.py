def solution(bridge_length, weight, truck_weights):
    # 시간의 흐름
    answer = 0
    # 다리 길이 [0,0]
    bridge_list = [0] * bridge_length 
    # 총합 변수
    tmp_sum = 0

    while bridge_list: 
        answer += 1
        tmp_pop = bridge_list.pop(0)
        tmp_sum -= tmp_pop
        # [0]
        if truck_weights:
            #print('truck_weights : ' , truck_weights)
            if tmp_sum + truck_weights[0] <= weight:
                tmp_sum += truck_weights[0]
                bridge_list.append(truck_weights.pop(0))
            # [0,7]
            else:
                bridge_list.append(0)

    return answer