N = int(input().strip()) 

max_dp = [0, 0, 0]
min_dp = [0, 0, 0]


first_row = list(map(int, input().split()))
max_dp[:] = first_row
min_dp[:] = first_row


for _ in range(N - 1):
    a, b, c = map(int, input().split())  

    new_max_dp = [
        a + max(max_dp[0], max_dp[1]),  
        b + max(max_dp[0], max_dp[1], max_dp[2]), 
        c + max(max_dp[1], max_dp[2]) 
    ]

    new_min_dp = [
        a + min(min_dp[0], min_dp[1]),
        b + min(min_dp[0], min_dp[1], min_dp[2]),
        c + min(min_dp[1], min_dp[2])
    ]


    max_dp = new_max_dp
    min_dp = new_min_dp

print(max(max_dp), min(min_dp))
