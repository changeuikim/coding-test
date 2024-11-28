# [Lv.3] [최고의 집합](https://school.programmers.co.kr/learn/courses/30/lessons/12938) - 12938 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(n, s):
    if n > s:
        return [-1]

    q, r = divmod(s, n)
    result = [q] * n

    for i in range(n - r, n):
        result[i] += 1

    return result
```

### 성능 요약

1. 시간: 0.71 ms, 메모리: 10.6 MB

2. 시간: 0.58 ms, 메모리: 11 MB
3. 시간: 0.58 ms, 메모리: 10.5 MB
4. 시간: 0.58 ms, 메모리: 10.5 MB
5. 시간: 0.40 ms, 메모리: 10.5 MB

### 제출 일자

2024년 11월 28일 (목) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges