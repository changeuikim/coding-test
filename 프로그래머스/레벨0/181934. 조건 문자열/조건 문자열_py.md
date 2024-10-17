# [Lv.0] [조건 문자열](https://school.programmers.co.kr/learn/courses/30/lessons/181934?language=python3) - 181934 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(ineq, eq, n, m):
    if ineq == ">" and eq == "=":
        return int(n >= m)
    elif ineq == ">" and eq == "!":
        return int(n > m)
    elif ineq == "<" and eq == "=":
        return int(n <= m)
    elif ineq == "<" and eq == "!":
        return int(n < m)

```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 10.1 MB

2. 시간: 0.00 ms, 메모리: 10.3 MB
3. 시간: 0.00 ms, 메모리: 10.3 MB
4. 시간: 0.00 ms, 메모리: 10.2 MB
5. 시간: 0.00 ms, 메모리: 10.2 MB

### 제출 일자

2024년 10월 18일 (금) 01:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges