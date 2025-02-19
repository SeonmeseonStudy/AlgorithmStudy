n = int(input().strip())  
MOD = 10007

dp = []  

for i in range(n + 1):  
    row = []  
    for j in range(10):  
        row.append(0)  
    dp.append(row)  

for j in range(10):
    dp[1][j] = 1

for i in range(2, n + 1):  
    dp[i][0] = dp[i - 1][0]  
    for j in range(1, 10):  
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD  

result = 0
for j in range(10):  
    result += dp[n][j]  
    result %= MOD  

print(result)
