# [Lv.1] [하샤드 수](https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=python3) - 12947 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(x):
    return x % sum(int(digit) for digit in str(x)) == 0
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 10.4 MB

2. 시간: 0.04 ms, 메모리: 10.3 MB
3. 시간: 0.03 ms, 메모리: 10.5 MB
4. 시간: 0.03 ms, 메모리: 10.4 MB
5. 시간: 0.03 ms, 메모리: 10.4 MB

### 제출 일자

2024년 11월 01일 (금) 22:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges