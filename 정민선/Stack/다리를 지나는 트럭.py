def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = [0] * bridge_length
    check = 0
    
    while truck_weights or check > 0:
        answer += 1
        check -= bridge.pop(0)
        if truck_weights:
            if truck_weights[0] + check <= weight:
                truck = truck_weights.pop(0)
                bridge.append(truck)
                check += truck
            else:
                bridge.append(0)
            
    return answer