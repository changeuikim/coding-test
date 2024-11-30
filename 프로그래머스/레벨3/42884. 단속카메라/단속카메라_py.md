# [Lv.3] [단속카메라](https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=python3) - 42884 

### 구분

코딩테스트 연습 > 탐욕법（Greedy）

## Python 문제풀이

```py
def solution(routes):
    camera = -30001
    result = 0

    routes.sort(key=lambda x: x[1])

    for route in routes:
        if camera < route[0]:
            result += 1
            camera = route[1]

    return result
```

### 성능 요약

1. 시간: 0.84 ms, 메모리: 10.5 MB

2. 시간: 0.70 ms, 메모리: 10.5 MB
3. 시간: 0.35 ms, 메모리: 10.4 MB
4. 시간: 0.33 ms, 메모리: 10.2 MB
5. 시간: 0.06 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 30일 (토) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges