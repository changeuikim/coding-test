# [Lv.1] [크기가 작은 부분문자열](https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=python3) - 147355 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(t, p):
    cnt = 0    
    for i in range(len(t) - len(p) + 1):
        window = t[i : i + len(p)]
        if window <= p:
            cnt += 1
            
    return cnt        
        
```

### 성능 요약

1. 시간: 1.81 ms, 메모리: 10.2 MB

2. 시간: 1.80 ms, 메모리: 9.95 MB
3. 시간: 1.79 ms, 메모리: 10.2 MB
4. 시간: 1.74 ms, 메모리: 10.2 MB
5. 시간: 1.70 ms, 메모리: 9.95 MB

### 제출 일자

2024년 11월 04일 (월) 21:31

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges