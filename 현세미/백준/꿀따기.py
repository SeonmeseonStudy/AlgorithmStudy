def max_honey(N, honey):
   
    prefix_sum = [0] * (N + 1)
    for i in range(N):
        prefix_sum[i + 1] = prefix_sum[i] + honey[i]
    
    max_honey = 0
    
    # 1. 벌통을 오른쪽 끝에 두는 경우
    for i in range(1, N - 1): 
        honey_amount = (prefix_sum[N] - honey[0] - honey[i]) + (prefix_sum[N] - prefix_sum[i + 1])
        max_honey = max(max_honey, honey_amount)

    # 2. 벌통을 왼쪽 끝에 두는 경우
    for i in range(1, N - 1):
        honey_amount = (prefix_sum[N] - honey[N - 1] - honey[i]) + (prefix_sum[i])
        max_honey = max(max_honey, honey_amount)

    # 3. 벌통을 중간에 두는 경우
    for i in range(1, N - 1):
        honey_amount = (prefix_sum[N] - honey[0] - honey[N - 1]) + honey[i]
        max_honey = max(max_honey, honey_amount)

    return max_honey

N = int(input())
honey = list(map(int, input().split()))

print(max_honey(N, honey))
