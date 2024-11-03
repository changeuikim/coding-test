# [Lv.1] [문자열 다루기 기본](https://school.programmers.co.kr/learn/courses/30/lessons/12918?language=python3) - 12918 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
import re

def solution(s):    
    return bool(re.fullmatch("^\d{4}$|^\d{6}$", s))
```

### 성능 요약

1. 시간: 0.19 ms, 메모리: 10.5 MB

2. 시간: 0.19 ms, 메모리: 10.4 MB
3. 시간: 0.19 ms, 메모리: 10.4 MB
4. 시간: 0.19 ms, 메모리: 10.3 MB
5. 시간: 0.18 ms, 메모리: 10.4 MB

### 제출 일자

2024년 11월 03일 (일) 21:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges