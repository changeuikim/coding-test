# [Lv.1] [가운데 글자 가져오기](https://school.programmers.co.kr/learn/courses/30/lessons/12903?language=python3) - 12903 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(s):
    n = len(s)
    start = (n - 1) // 2
    end = n // 2 + 1
    return s[start:end]
```

### 성능 요약

1. 시간: 0.00 ms, 메모리: 10.3 MB

2. 시간: 0.00 ms, 메모리: 10.3 MB
3. 시간: 0.00 ms, 메모리: 10.2 MB
4. 시간: 0.00 ms, 메모리: 10.2 MB
5. 시간: 0.00 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 02일 (토) 21:33

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges