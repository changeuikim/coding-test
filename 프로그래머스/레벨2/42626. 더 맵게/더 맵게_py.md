# [Lv.2] [더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=python3) - 42626 

### 구분

코딩테스트 연습 > 힙（Heap）

## Python 문제풀이

```py
from heapq import heapify, heappush, heappop

def solution(scoville, K):
    heap = scoville
    count = 0
    
    heapify(heap)
    
    while heap[0] < K:
        if len(heap) < 2:
            return -1
        
        first = heappop(heap)
        second = heappop(heap)
        heappush(heap, first + second * 2)
        count += 1
    
    return count
```

### 성능 요약

1. 시간: 1607.27 ms, 메모리: 51.8 MB

2. 시간: 1484.46 ms, 메모리: 49.8 MB
3. 시간: 347.02 ms, 메모리: 21.9 MB
4. 시간: 159.66 ms, 메모리: 16.3 MB
5. 시간: 124.33 ms, 메모리: 15 MB

### 제출 일자

2024년 11월 19일 (화) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges