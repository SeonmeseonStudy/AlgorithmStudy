import heapq
import sys

input = sys.stdin.readline

n = int(input())
heap = []

for i in range(n):
    number = int(input())
    
    if number == 0:
        remove = 0
        if len(heap) != 0:
            remove = heapq.heappop(heap)
        print(remove)
    else:
        heapq.heappush(heap, number)