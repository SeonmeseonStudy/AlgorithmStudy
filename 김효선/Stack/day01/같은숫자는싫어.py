def solution(arr):
    answer = []
    
    x=0
    
    for i in range(len(arr)):
        if i==0:
            answer.append(arr[i])
        elif i!=0:
            if arr[i-1] == arr[i]:
                continue
            else :
                answer.append(arr[i])

    return answer