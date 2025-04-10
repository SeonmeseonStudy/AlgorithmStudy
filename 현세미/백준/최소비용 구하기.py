import heapq

def dijkstra(n, g, s, e):
    d = [float('inf')] * (n + 1)
    d[s] = 0
    h = [(0, s)]

    while h:
        c, x = heapq.heappop(h)
        if d[x] < c:
            continue
        for nx, nc in g[x]:
            t = c + nc
            if t < d[nx]:
                d[nx] = t
                heapq.heappush(h, (t, nx))

    return d[e]

n = int(input())
m = int(input())
g = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    g[a].append((b, c))

s, e = map(int, input().split())
print(dijkstra(n, g, s, e))
