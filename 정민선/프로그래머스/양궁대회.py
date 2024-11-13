from itertools import product

def solution(n, info):
    answer = [-1]
    info.reverse()
    max_diff = 0
    
    for game in product((True, False), repeat=11):
        arrows = 0
        apeach = 0
        ryan = 0
        
        for i in range(11):
            if game[i]: # 게임 진행
                arrows += info[i] + 1 # 어피치보다 1개 더 맞힘
                ryan += i
            else:
                if info[i] > 0: # 어피치 점수 획득
                    apeach += i
        if arrows > n:
            continue
        
        diff = ryan-apeach
        if diff > max_diff:
            max_diff = diff
            answer = []
            for i in range(11):
                if game[i]:
                    answer.append(info[i]+1)
                else:
                    answer.append(0)
            answer[0] += n-arrows
        
    answer.reverse()    
    return answer