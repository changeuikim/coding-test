# [Lv.1] [음양 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/76501?language=python3) - 76501 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## Python 문제풀이

```py
def solution(absolutes, signs):
    return sum(absolutes[i] * (1 if signs[i] else -1) for i in range(len(absolutes)))
        
```

### 성능 요약

1. 시간: 0.11 ms, 메모리: 10.3 MB

2. 시간: 0.11 ms, 메모리: 10.3 MB
3. 시간: 0.11 ms, 메모리: 10.3 MB
4. 시간: 0.11 ms, 메모리: 10.3 MB
5. 시간: 0.11 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 02일 (토) 19:35

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges