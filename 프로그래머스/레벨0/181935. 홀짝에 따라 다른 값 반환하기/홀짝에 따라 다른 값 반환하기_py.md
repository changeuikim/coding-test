# [Lv.0] [홀짝에 따라 다른 값 반환하기](https://school.programmers.co.kr/learn/courses/30/lessons/181935?language=python3) - 181935 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(n):
    if n&1:
        return sum(x for x in range(1, n + 1, 2))
    else:
        return sum(x*x for x in range(2, n + 1, 2))
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 10.3 MB

2. 시간: 0.01 ms, 메모리: 10.3 MB
3. 시간: 0.01 ms, 메모리: 10.3 MB
4. 시간: 0.01 ms, 메모리: 10.3 MB
5. 시간: 0.01 ms, 메모리: 10.2 MB

### 제출 일자

2024년 10월 18일 (금) 00:18

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges