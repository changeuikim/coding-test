# [Lv.1] [약수의 개수와 덧셈](https://school.programmers.co.kr/learn/courses/30/lessons/77884?language=python3) - 77884 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## Python 문제풀이

```py
from math import sqrt

def solution(left, right):
    result = 0
    for num in range(left, right + 1):
        if sqrt(num).is_integer():
            result -= num
        else:
            result += num
    return result
```

### 성능 요약

1. 시간: 0.21 ms, 메모리: 10.2 MB

2. 시간: 0.13 ms, 메모리: 10.1 MB
3. 시간: 0.05 ms, 메모리: 10.2 MB
4. 시간: 0.04 ms, 메모리: 10.2 MB
5. 시간: 0.02 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 02일 (토) 22:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges