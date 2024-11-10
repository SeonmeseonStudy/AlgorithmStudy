#백준 - 1522. 문자열 교환
s = input().strip()

count_a = 0
for char in s:
    if char == 'a':
        count_a += 1

# 2원형 문자열처럼 처리 -> 문자열을 두 번 이어 붙임
doubled_s = s + s

#b갯수 계산후 최소 교환 횟수로 지정
current_b_count = 0
for i in range(count_a):
    if doubled_s[i] == 'b':
        current_b_count += 1

min_swaps = current_b_count

for i in range(1, len(s)):
    if doubled_s[i - 1] == 'b':
        current_b_count -= 1
    if doubled_s[i + count_a - 1] == 'b':
        current_b_count += 1

    min_swaps = min(min_swaps, current_b_count)

print(min_swaps)
