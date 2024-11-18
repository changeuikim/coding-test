# [Lv.2] [땅따먹기](https://school.programmers.co.kr/learn/courses/30/lessons/12913?language=python3) - 12913 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(land):
    n = len(land)
    m = 4
    
    # 2행부터 DP
    for i in range(1, n):
        max1, idx, max2 = -1, -1, -1
        
        # 이전행 최대, 차대 찾기
        for j in range(m):
            cur = land[i - 1][j]
            
            if cur > max1:
                max2 = max1
                max1 = cur
                idx = j
            elif cur > max2:
                max2 = cur
        
        # 이번행 DP
        for j in range(m):
            prev = max1;            
            if j == idx:
                prev = max2
            
            land[i][j] += prev
        
    return max(land[n - 1])
```

### 성능 요약

1. 시간: 123.64 ms, 메모리: 32.4 MB

2. 시간: 123.08 ms, 메모리: 32.5 MB
3. 시간: 122.86 ms, 메모리: 32.5 MB
4. 시간: 120.36 ms, 메모리: 32.5 MB
5. 시간: 2.61 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 18일 (월) 22:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges