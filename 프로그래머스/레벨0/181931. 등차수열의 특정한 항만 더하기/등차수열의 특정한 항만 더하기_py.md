# [Lv.0] [등차수열의 특정한 항만 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/181931?language=python3) - 181931 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(a, d, included):
    return sum((a + i*d) for i, flag in enumerate(included) if flag)

```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 10.2 MB

2. 시간: 0.01 ms, 메모리: 10.3 MB
3. 시간: 0.01 ms, 메모리: 10.3 MB
4. 시간: 0.01 ms, 메모리: 10.3 MB
5. 시간: 0.01 ms, 메모리: 10.3 MB

### 제출 일자

2024년 10월 18일 (금) 09:13

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges