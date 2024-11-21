# [Lv.3] [야근 지수](https://school.programmers.co.kr/learn/courses/30/lessons/12927?language=python3) - 12927 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
from heapq import heapify, heappush, heappop

def solution(n, works):
    if sum(works) <= n:
        return 0
    
    # 최대힙
    max_heap = [-work for work in works]
    heapify(max_heap)
        
    # heappushpop
    for _ in range(n):
        work = heappop(max_heap)
        if work == 0:
            break;
            
        heappush(max_heap, work + 1)
    
    # 최종 결과
    return sum(work ** 2 for work in max_heap)
```

### 성능 요약

1. 시간: 350.52 ms, 메모리: 10.4 MB

2. 시간: 319.04 ms, 메모리: 10.3 MB
3. 시간: 0.55 ms, 메모리: 10.2 MB
4. 시간: 0.42 ms, 메모리: 10.3 MB
5. 시간: 0.07 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 21일 (목) 23:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges