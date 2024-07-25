from collections import deque

def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    
    for node in edge: # 각 숫자랑 연결된 노드 번호 저장 1번은 3, 2
        graph[node[0]].append(node[1])
        graph[node[1]].append(node[0])

    queue = deque([1]) # 시작점
    count = [-1] * (n+1)
    count[1] = 0
        
    while queue:
        now = queue.popleft()
        for i in graph[now]:
            if count[i] == -1:
                queue.append(i)
                count[i] = count[now] + 1
    
    check = max(count)
    
    for n in count:
        if n == check:
            answer += 1
    
    return answer

n = 6
edge = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	

print(solution(n, edge))