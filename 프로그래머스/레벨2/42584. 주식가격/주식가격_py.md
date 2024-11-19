# [Lv.2] [주식가격](https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=python3) - 42584 

### 구분

코딩테스트 연습 > 스택／큐

## Python 문제풀이

```py
def solution(prices):
    n = len(prices)
    stack = [-1] * n
    top = -1
    
    # 인덱스의 역순으로 결과 배열을 초기화
    result = list(range(n - 1, -1, -1))
    
    # 단조 스택
    for idx, cur in enumerate(prices):
        while top > -1 and cur < prices[stack[top]]:
            prev_idx = stack[top]
            top -=1
            result[prev_idx] = idx - prev_idx
        
        top += 1
        stack[top] = idx
    
    return result
```

### 성능 요약

1. 시간: 29.04 ms, 메모리: 20 MB

2. 시간: 25.54 ms, 메모리: 19.8 MB
3. 시간: 21.96 ms, 메모리: 18.5 MB
4. 시간: 19.18 ms, 메모리: 17.9 MB
5. 시간: 17.20 ms, 메모리: 17.1 MB

### 제출 일자

2024년 11월 19일 (화) 23:21

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges