# 타노스
import sys

s = list(sys.stdin.readline().rstrip())

n = s.count('0')
m = s.count('1')

#앞에서부터 1을 갯수의 절반 만큼 지우고, 뒤에서부터 0을 갯수의 절반 만큼 지우자.
# 리스트를 역순하는 가장 쉬운 방법 [::-1]

check = 0
for i in s:
    if check == m//2:
        break
    if i == '1':
        s.remove(i)
        check += 1

check = 0
s = s[::-1]
for i in s:
    if check == n//2:
        break
    if i == '0':
        s.remove(i)
        check += 1

for i in s[::-1]:
    print(i, end='')