# [Lv.1] [나머지가 1이 되는 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/87389) - 87389 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

## Python 문제풀이

```py
def solution(n):    
    return next((x for x in range(2, n) if n % x == 1), n - 1)
```

### 성능 요약

1. 시간: 59.92 ms, 메모리: 10 MB

2. 시간: 0.07 ms, 메모리: 10 MB
3. 시간: 0.04 ms, 메모리: 10.1 MB
4. 시간: 0.02 ms, 메모리: 10.2 MB
5. 시간: 0.01 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 01일 (금) 18:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges