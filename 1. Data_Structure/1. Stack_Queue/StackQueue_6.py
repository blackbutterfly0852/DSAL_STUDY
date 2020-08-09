# 쇠막대기
def solution(arrangement) :
    arrangement = list(arrangement)
    tmp_answer = []
    open = '('
    close = ')'
    
    non_count = 0
    slice_count = 0
    
    while arrangement:
        start = arrangement.pop(0)
        if start == open:
            non_count +=1
            slice_count +=1
        else: 
            # 레이저
            if tmp_answer[-1] == open:
                non_count-=1
                slice_count-=1
                slice_count+=non_count
             # 막대끝
            else:
                non_count-=1
        tmp_answer.append(start)
           
    return slice_count



print(solution('()(((()())(())()))(())'))

