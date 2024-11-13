#백준 12919. A와 B 2

S = input().strip()
T = input().strip()

def dfs(t):
    if t == S:
        print(1)
        exit()
    if len(t) <= len(S):
        return
    if t[-1] == 'A':
        dfs(t[:-1])
    if t[0] == 'B':
        dfs(t[1:][::-1])

dfs(T)
print(0)
