import heapq

def solution(scoville, K):
    heapq.heapify(scoville) 
    answer = 0
    
    while scoville[0] < K:
        if len(scoville) < 2:
            return -1
        
        heap1 = heapq.heappop(scoville)
        heap2 = heapq.heappop(scoville)
        
        new_scoville = heap1 + (heap2 * 2)
        heapq.heappush(scoville, new_scoville)
        
        answer += 1
    
    return answer
