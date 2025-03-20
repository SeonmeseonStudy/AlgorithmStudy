# 유니온 파인드(분리 집합) 사용
n, m = map(int, input().split())

p = list(range(n + 1))
r = [0] * (n + 1)  

def find(x):
    while p[x] != x:  
        p[x] = p[p[x]] 
        x = p[x]
    return x

def union(a, b):
    pa = find(a)
    pb = find(b)
    
    if pa != pb:
        if r[pa] > r[pb]:
            p[pb] = pa  
        elif r[pa] < r[pb]:
            p[pa] = pb
        else:
            p[pb] = pa
            r[pa] += 1 

res = []
for _ in range(m):
    t, a, b = map(int, input().split())
    if t == 0:
        union(a, b)
    elif t == 1:
        res.append("YES" if find(a) == find(b) else "NO")

print("\n".join(res))  
