# [Lv.1] [두 정수 사이의 합](https://school.programmers.co.kr/learn/courses/30/lessons/12912?language=python3) - 12912 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(a, b):    
    if a > b:
        a, b = b, a        
    return sum(range(a, b + 1))
```

### 성능 요약

1. 시간: 411.30 ms, 메모리: 9.99 MB

2. 시간: 248.18 ms, 메모리: 10.1 MB
3. 시간: 212.69 ms, 메모리: 10.2 MB
4. 시간: 207.76 ms, 메모리: 10.2 MB
5. 시간: 173.52 ms, 메모리: 9.94 MB

### 제출 일자

2024년 11월 01일 (금) 18:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges