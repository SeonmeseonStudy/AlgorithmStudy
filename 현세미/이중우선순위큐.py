import heapq

def solution(operations):
    min_heap = []  
    max_heap = [] 
    entry_count = {}  

    for operation in operations:
        if operation.startswith('I'):
            num = int(operation.split()[1])
            heapq.heappush(min_heap, num)
            heapq.heappush(max_heap, -num)
            entry_count[num] = entry_count.get(num, 0) + 1
        elif operation == 'D 1':
            # 최댓값 삭제
            while max_heap and entry_count[-max_heap[0]] == 0:
                heapq.heappop(max_heap)
            if max_heap:
                max_val = -heapq.heappop(max_heap)
                entry_count[max_val] -= 1
        elif operation == 'D -1':
            # 최솟값 삭제
            while min_heap and entry_count[min_heap[0]] == 0:
                heapq.heappop(min_heap)
            if min_heap:
                min_val = heapq.heappop(min_heap)
                entry_count[min_val] -= 1


    while min_heap and entry_count[min_heap[0]] == 0:
        heapq.heappop(min_heap)
    while max_heap and entry_count[-max_heap[0]] == 0:
        heapq.heappop(max_heap)

    if min_heap and max_heap:
        return [-max_heap[0], min_heap[0]]
    else:
        return [0, 0]
