def solve(n, k):
    nums = list(range(1, n + 1))
    ans = []
    i = 0

    while nums:
        i = (i + k - 1) % len(nums)
        ans.append(nums.pop(i))

    print(f"<{', '.join(map(str, ans))}>")

n, k = map(int, input().split())
solve(n, k)
