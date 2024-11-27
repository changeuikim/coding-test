# [Lv.2] [숫자 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/154538?language=python3) - 154538 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
from collections import deque

def solution(x, y, n):
    if x == y:
        return 0

    dp = { y : 0 }
    q = deque([y])

    while q:
        curr = q.popleft()
        
        # 종료 조건
        if curr == x:
            return dp[curr]
        
        # 역방향 탐색
        prev_values = []
           
        if curr - n >= x:
            prev_values.append(curr - n)
        if curr % 2 == 0:
            prev_values.append(curr // 2)
        if curr % 3 == 0:
            prev_values.append(curr // 3)

        # DP에 추가
        for prev in prev_values:
            if prev not in dp:
                dp[prev] = dp[curr] + 1
                q.append(prev)

    return -1
```

### 성능 요약

1. 시간: 0.55 ms, 메모리: 10.4 MB

2. 시간: 0.52 ms, 메모리: 10.3 MB
3. 시간: 0.49 ms, 메모리: 10.4 MB
4. 시간: 0.31 ms, 메모리: 10.4 MB
5. 시간: 0.30 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 27일 (수) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges