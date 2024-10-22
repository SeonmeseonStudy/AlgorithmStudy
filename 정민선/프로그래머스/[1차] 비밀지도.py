def solution(n, arr1, arr2):
    answer = []
    board = [[' ']*n for _ in range(n)]
    for i in range(n):
        b1num = bin(arr1[i])[::-1][:-2]
        b2num = bin(arr2[i])[::-1][:-2]
        
        for j in range(n):
            if len(b1num) > j and b1num[j] == "1":
                board[i][j] = "#"
                continue
                
            if len(b2num) > j and b2num[j] == "1":
                board[i][j] = "#"
    
    for i in range(n):
        answer.append("".join(board[i][::-1]))
    
    return answer