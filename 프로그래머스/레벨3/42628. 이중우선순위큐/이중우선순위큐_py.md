# [Lv.3] [이중우선순위큐](https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=python3) - 42628 

### 구분

코딩테스트 연습 > 힙（Heap）

## Python 문제풀이

```py
from heapq import heappush, heappop

def remove_invalid(heap, counter, is_max_heap=False):
    """카운터에 없는 유효하지 않은 값을 힙에서 제거하는 함수"""
    while heap and not counter.get(-heap[0] if is_max_heap else heap[0], 0):
        heappop(heap)

def solution(operations):
    # 최소힙, 최대힙, 값 카운터
    min_heap = []
    max_heap = []
    counter = dict()
    
    for element in operations:
        op, val = element.split()
        val = int(val)
        
        # 큐에 주어진 숫자를 삽입합니다.
        if op == "I":
            heappush(min_heap, val)
            heappush(max_heap, -val)
            counter[val] = counter.get(val, 0) + 1
        
        elif op == "D":
            # 큐에서 최댓값을 삭제합니다.
            if val == 1:
                remove_invalid(max_heap, counter, is_max_heap=True)
                if max_heap:
                    max_val = -heappop(max_heap)
                    counter[max_val] -= 1
                    
            # 큐에서 최솟값을 삭제합니다.
            elif val == -1:
                remove_invalid(min_heap, counter)
                if min_heap:
                    min_val = heappop(min_heap)
                    counter[min_val] -= 1
        
    # 잔여 카운터를 처리합니다.
    remove_invalid(max_heap, counter, is_max_heap=True)
    remove_invalid(min_heap, counter)
            
    # 결과 반환
    if min_heap and max_heap:
        return [-max_heap[0], min_heap[0]]
    else:
        return [0, 0]

```

### 성능 요약

1. 시간: 94.16 ms, 메모리: 19.7 MB

2. 시간: 0.08 ms, 메모리: 10.4 MB
3. 시간: 0.08 ms, 메모리: 10.4 MB
4. 시간: 0.04 ms, 메모리: 10.2 MB
5. 시간: 0.03 ms, 메모리: 10.4 MB

### 제출 일자

2024년 11월 12일 (화) 23:24

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges