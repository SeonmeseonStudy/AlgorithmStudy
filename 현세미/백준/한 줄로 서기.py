N = int(input()) 
left = list(map(int, input().split())) 

line = [0] * N

for i in range(1, N + 1):
    count = left[i - 1]
    
    for j in range(N):
        if line[j] == 0:
            if count == 0:
                line[j] = i
                break
            count -= 1

for i in range(N):
    print(line[i], end=' ')
