def solution(citations):
    answer = 0
    citations.sort(reverse=True)

    for index, c in enumerate(citations):
        if c > answer:
            answer = index+1
        else:
            break

    return answer