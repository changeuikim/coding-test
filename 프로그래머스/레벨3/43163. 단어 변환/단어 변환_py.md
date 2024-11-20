# [Lv.3] [단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=python3) - 43163 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## Python 문제풀이

```py
from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0
    
    queue = deque([(begin, 0)])
    visited = [False] * len(words)
    
    while queue:
        cur, cnt = queue.popleft()
        
        # 종료조건
        if cur == target:
            return cnt
        
        # 1글자만 다르다면 엔큐
        for idx, word in enumerate(words):
            if visited[idx]:
                continue
            
            # 자리별 차이 계산
            dif = 0
            for i in range(len(begin)):
                if cur[i] != word[i]:
                    dif += 1
                if dif > 1:
                    break

            # 엔큐
            if dif == 1:
                visited[idx] = True     
                queue.append((word, cnt + 1))
    
    return 0
```

### 성능 요약

1. 시간: 0.39 ms, 메모리: 10.1 MB

2. 시간: 0.06 ms, 메모리: 10.2 MB
3. 시간: 0.01 ms, 메모리: 10.3 MB
4. 시간: 0.01 ms, 메모리: 10.2 MB
5. 시간: 0.00 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 20일 (수) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges