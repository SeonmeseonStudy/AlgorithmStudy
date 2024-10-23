# 2075. N번째 큰수
import heapq

N = int(input())
heap_list = [] 

for _ in range(N):
    numbers = list(map(int, input().split()))  
    
    for i in numbers:  

        if len(heap_list) < N: 
            heapq.heappush(heap_list, i) 
            
        else:
            if i > heap_list[0]:
                heapq.heappop(heap_list) 
                heapq.heappush(heap_list, i) 

print(heap_list[0])
