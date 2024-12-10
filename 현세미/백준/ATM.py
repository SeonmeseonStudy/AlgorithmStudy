def atm_min_time(n, t):
    t.sort()
    total = 0
    acc = 0

    for x in t:
        acc += x
        total += acc

    return total

n = int(input())
t = list(map(int, input().split()))
print(atm_min_time(n, t))
