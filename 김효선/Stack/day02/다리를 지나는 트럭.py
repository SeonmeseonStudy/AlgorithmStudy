import queue

def solution(bridge_length, weight, truck_weights):
    bridge_queue = queue.Queue(maxsize=bridge_length)
    current_weight = 0
    time = 0
    
    for _ in range(bridge_length):
        bridge_queue.put(0)
    
    for i in truck_weights:
        while True:
            current_weight -= bridge_queue.get()
            if current_weight + i <= weight:
                bridge_queue.put(i)
                current_weight += i
                time += 1
                break
            else:
                bridge_queue.put(0)
                time += 1
    
    return time + bridge_length

