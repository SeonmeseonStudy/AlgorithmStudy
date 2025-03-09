def diff(arr):
    return sum(abs(arr[i] - arr[i+1]) for i in range(len(arr) - 1))

def dfs(depth):
    global max_val
    if depth == n:
        max_val = max(max_val, diff(temp))
        return

    for i in range(n):
        if not used[i]:
            used[i] = True
            temp.append(nums[i])
            dfs(depth + 1)
            temp.pop()
            used[i] = False

n = int(input())
nums = list(map(int, input().split()))

max_val = 0
used = [False] * n
temp = []

dfs(0)

print(max_val)
