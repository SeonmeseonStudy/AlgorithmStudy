def solution(s):
    answer = True
    x, y = 0, 0
    for i in s.upper():
        if i == "P":
            x += 1
        elif i == "Y":
            y += 1
            
    if x == y:
        answer = True
    else:
        answer = False

    return answer