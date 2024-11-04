# [Lv.1] [예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=python3) - 12982 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Python 문제풀이

```py
def solution(d, budget):
    d.sort()
    count = 0
    
    for cost in d:
        budget -= cost
        if budget < 0:
            break
        count += 1

    return count

```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 10.1 MB

2. 시간: 0.02 ms, 메모리: 10.2 MB
3. 시간: 0.02 ms, 메모리: 10 MB
4. 시간: 0.01 ms, 메모리: 10.3 MB
5. 시간: 0.01 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 04일 (월) 23:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges