# [Lv.0] [두 수의 연산값 비교하기](https://school.programmers.co.kr/learn/courses/30/lessons/181938?language=python3) - 181938 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(a, b):
    left = int(f'{a}{b}')
    right = 2 * a * b
    return max(left, right)
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 10.3 MB

2. 시간: 0.02 ms, 메모리: 10.4 MB
3. 시간: 0.02 ms, 메모리: 10.4 MB
4. 시간: 0.02 ms, 메모리: 10.4 MB
5. 시간: 0.02 ms, 메모리: 10.4 MB

### 제출 일자

2024년 10월 17일 (목) 02:21

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges