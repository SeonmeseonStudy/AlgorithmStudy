import sys
input = sys.stdin.read
data = input().split()

N = int(data[0])
A = set(map(int, data[1:N+1]))
M = int(data[N+1])
queries = list(map(int, data[N+2:]))

results = []
for x in queries:
    if x in A:
        results.append(1)
    else:
        results.append(0)

print("\n".join(map(str, results)))
