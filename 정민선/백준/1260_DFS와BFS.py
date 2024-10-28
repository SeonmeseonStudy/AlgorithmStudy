n, m, v = map(int, input().split())
board = [[] for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    board[x].append(y)
    board[y].append(x)

for i in range(n+1):
    board[i].sort()

stack = []
visited = [False] * (n+1)

def dfs(now):
    visited[now] = True
    stack.append(now)
    for i in board[now]:
        if not visited[i]:
            dfs(i)

dfs(v)
print(" ".join(map(str, stack)))

from collections import deque
queue = deque()
stack = []
visited = [False] * (n+1)
def bfs(now):
    visited[now] = True
    queue = deque([now])
    stack.append(now)
    while queue:
        node = queue.popleft()
        for i in board[node]:
            if not visited[i]:
                queue.append(i)
                stack.append(i)
                visited[i] = True
                
bfs(v)
print(" ".join(map(str, stack)))