def solution(progresses, speeds):
    answer = []
    days = []
    
    for p, s in zip(progresses, speeds):
        remain = 100 - p
        time = (remain + s) // s
        days.append(time)
        
    while days:
        day = days.pop(0)
        count = 1
        
        while days and days[0] <= day:
            days.pop(0)
            count += 1
        
        answer.append(count)
    
    return answer

progresses = [95, 90, 99, 99, 80, 99]
speeds = [1, 1, 1, 1, 1, 1]
print(solution(progresses, speeds))