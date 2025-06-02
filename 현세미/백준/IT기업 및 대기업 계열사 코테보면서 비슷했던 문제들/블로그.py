def solve():
    N, X = map(int, input().split())
    visits = list(map(int, input().split()))

    current_sum = sum(visits[:X]) 
    max_sum = current_sum  
    count = 1 

    for i in range(X, N):
        current_sum += visits[i] - visits[i - X]
        if current_sum > max_sum:
            max_sum = current_sum
            count = 1
        elif current_sum == max_sum:
            count += 1

    if max_sum == 0:
        print("SAD")
    else:
        print(max_sum)
        print(count)

solve()
