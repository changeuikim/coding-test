from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque([0] * bridge_length)
    total_weight = 0
    time = 0
    
    for truck in truck_weights:
        while True:
            time += 1
            total_weight -= bridge.popleft()
            
            if total_weight + truck <= weight:
                bridge.append(truck)
                total_weight += truck
                break
            else:
                bridge.append(0)
    
    return time + bridge_length