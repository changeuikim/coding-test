# [Lv.1] [핸드폰 번호 가리기](https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=python3) - 12948 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
import re

def solution(phone_number):
    return re.sub(r'\d(?=\d{4})', '*', phone_number);
```

### 성능 요약

1. 시간: 0.14 ms, 메모리: 10.3 MB

2. 시간: 0.14 ms, 메모리: 10.3 MB
3. 시간: 0.13 ms, 메모리: 10.3 MB
4. 시간: 0.13 ms, 메모리: 10.1 MB
5. 시간: 0.12 ms, 메모리: 10.1 MB

### 제출 일자

2024년 11월 02일 (토) 21:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges