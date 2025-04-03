def main():
    # 회원 수 입력
    n = int(input())  
    INF = float('inf')  # 무한대 값 

    # 친구 관계를 저장할 2차원 리스트 생성
    board = [[INF] * (n + 1) for _ in range(n + 1)]  
    for i in range(1, n + 1):
        board[i][i] = 0 

    # 친구 관계 입력 받기
    while True:
        a, b = map(int, input().split())
        if a == -1 and b == -1:  
            break
        board[a][b] = 1
        board[b][a] = 1  

    # 플로이드-워셜 알고리즘 - 모든 회원 간 최단 거리 계산
    for k in range(1, n + 1):  
        for i in range(1, n + 1): 
            for j in range(1, n + 1):  
                board[i][j] = min(board[i][j], board[i][k] + board[k][j])

    # 각 회원의 점수(최대 거리) 구하기
    min_score = INF
    result = []
    
    for i in range(1, n + 1):
        score = max(board[i][1:]) 
        if score < min_score:
            min_score = score
            result = [i]
        elif score == min_score:
            result.append(i)

    print(min_score, len(result))
    print(*result)

main()
