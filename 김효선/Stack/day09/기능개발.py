def solution(progresses, speeds):
    from math import ceil
    answer = []
    days = []

    for i in range(len(progresses)):
        days.append(ceil((100 - progresses[i]) / speeds[i]))

    current_day = days[0]
    count = 0

    for day in days:
        if day <= current_day:
            count += 1
        else:
            answer.append(count)
            current_day = day
            count = 1

    answer.append(count)

    return answer
