# [Lv.0] [수 조작하기 1](https://school.programmers.co.kr/learn/courses/30/lessons/181926?language=python3) - 181926 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(n, control):
    ops = { "w" : 1, "s" : -1, "d" : 10, "a" : -10 }
    
    for key in control:
        n += ops[key]
    
    return n
```

### 성능 요약

1. 시간: 5.38 ms, 메모리: 10.2 MB

2. 시간: 5.30 ms, 메모리: 10.3 MB
3. 시간: 4.24 ms, 메모리: 10.3 MB
4. 시간: 4.16 ms, 메모리: 10.3 MB
5. 시간: 3.58 ms, 메모리: 10.4 MB

### 제출 일자

2024년 10월 19일 (토) 21:12

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges