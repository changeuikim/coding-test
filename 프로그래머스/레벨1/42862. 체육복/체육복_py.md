# [Lv.1] [체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=python3) - 42862 

### 구분

코딩테스트 연습 > 탐욕법（Greedy）

## Python 문제풀이

```py
def solution(n, lost, reserve):
    students = [1] * (n + 1)
    students[0] = 0
    
    for i in lost:
        students[i] -= 1
    
    for i in reserve:
        students[i] += 1
        
    for i in range(1, n + 1):
        if students[i] == 2:
            if i > 1 and students[i - 1] == 0:
                students[i - 1] += 1
                students[i] -= 1
            elif i < n and students[i + 1] == 0:
                students[i + 1] += 1
                students[i] -= 1
    
    result = 0
    for i in range(1, n + 1):
        if students[i] > 0:
            result += 1
    
    return result
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 10.2 MB

2. 시간: 0.01 ms, 메모리: 10.4 MB
3. 시간: 0.01 ms, 메모리: 10.4 MB
4. 시간: 0.01 ms, 메모리: 10.4 MB
5. 시간: 0.01 ms, 메모리: 10.4 MB

### 제출 일자

2024년 11월 30일 (토) 20:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges