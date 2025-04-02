n = int(input().strip())

graph = []
for _ in range(n):  
    line = input().split()
    row = list(map(int, line))
    graph.append(row)

for k in range(n):
    for i in range(n):
        for j in range(n):
            if graph[i][k] == 1 and graph[k][j] == 1:
                graph[i][j] = 1

for row in graph:
    print(" ".join(map(str, row)))
