N = 30
catalan = [0] * (N + 1)

catalan[0] = 1  

for n in range(1, N + 1):  
    for i in range(n):  
        catalan[n] += catalan[i] * catalan[n - 1 - i]

while True:
    num = int(input())  
    if num == 0:  
        break
    print(catalan[num])  
