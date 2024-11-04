# [Lv.1] [최대공약수와 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12940?language=python3) - 12940 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def gcd(n, m):
    while m > 0:
        n, m = m, n % m
    return n

def lcm(n, m):
    return n * m // gcd(n, m)

def solution(n, m):
    return [gcd(n, m), lcm(n, m)]
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 10.3 MB

2. 시간: 0.00 ms, 메모리: 10.3 MB
3. 시간: 0.00 ms, 메모리: 10.2 MB
4. 시간: 0.00 ms, 메모리: 10.2 MB
5. 시간: 0.00 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 04일 (월) 20:41

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges