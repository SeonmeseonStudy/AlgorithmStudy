# 에디터
import sys
from collections import deque

input = sys.stdin.readline

s = input().strip()

M = int(input().strip())

# 왼쪽과 오른쪽을 관리하는 deque
left = deque(s)  
right = deque()               

for _ in range(M):
    command = input().strip()
    
    if command == "L":
        if left: 
            right.appendleft(left.pop())  
    elif command == "D":
        if right:  
            left.append(right.popleft())  
    elif command == "B":
        if left:  
            left.pop()  
    elif command.startswith("P "):
        P, char = command.split()  
        left.append(char)  

result = ''.join(left) + ''.join(right)
print(result)
