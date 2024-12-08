n = int(input())
numbers = [tuple(map(int, input().split())) for _ in range(n-1)]

board = [[] for _ in range(n+1)]
for x, y in numbers:
    board[x].append(y)
    board[y].append(x)
    
visited = [False] * (n+1)
parent = [-1] * (n+1)

def find(x, p):
    stack = [(x, p)]
    
    while stack:
        sx, sp = stack.pop()
        if not visited[sx]:
            visited[sx] = True
            parent[sx] = sp
            for node in board[sx]:
                if not visited[node]:
                    stack.append((node, sx))
    
find(1, -1)
for i in range(2, n+1):
    print(parent[i])