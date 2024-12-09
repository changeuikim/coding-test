# [Lv.2] [다리를 지나는 트럭](https://programmers.co.kr/) - 42583 

### 구분

코딩테스트 연습 > 스택／큐

## Python 문제풀이

```py
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
```

### 성능 요약

1. 시간: 43.10 ms, 메모리: 10.3 MB

2. 시간: 13.16 ms, 메모리: 10.2 MB
3. 시간: 5.15 ms, 메모리: 10.3 MB
4. 시간: 5.03 ms, 메모리: 10.2 MB
5. 시간: 1.68 ms, 메모리: 10.2 MB

### 제출 일자

2024년 12월 09일 (월) 22:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges