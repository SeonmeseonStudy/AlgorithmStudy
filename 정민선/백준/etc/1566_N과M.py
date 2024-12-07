from itertools import permutations
n, m = map(int, input().split())
numbers = list(map(int, input().split()))

result = []
for i in permutations(numbers, m):
    result.append(i)
    
result = list(set(result))
result.sort(key=lambda x : [x[i] for i in range(m)])
for i in result:
    print(" ".join(map(str, i)))