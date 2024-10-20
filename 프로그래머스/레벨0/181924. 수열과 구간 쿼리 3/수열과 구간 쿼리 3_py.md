# [Lv.0] [수열과 구간 쿼리 3](https://school.programmers.co.kr/learn/courses/30/lessons/181924?language=python3) - 181924 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(arr, queries):
    for u, v in queries:
        arr[u], arr[v] = arr[v], arr[u]
    return arr
```

### 성능 요약

1. 시간: 0.08 ms, 메모리: 10.3 MB

2. 시간: 0.06 ms, 메모리: 10.4 MB
3. 시간: 0.06 ms, 메모리: 10.3 MB
4. 시간: 0.06 ms, 메모리: 10.2 MB
5. 시간: 0.06 ms, 메모리: 10.2 MB

### 제출 일자

2024년 10월 20일 (일) 22:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges