# [Lv.1] [삼총사](https://school.programmers.co.kr/learn/courses/30/lessons/131705?language=python3) - 131705 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(number):
    count = 0
    n = len(number)

    for i in range(n):
        for j in range(i + 1, n):
            for k in range(j + 1, n):
                if number[i] + number[j] + number[k] == 0:
                    count += 1

    return count

```

### 성능 요약

1. 시간: 0.11 ms, 메모리: 10.1 MB

2. 시간: 0.07 ms, 메모리: 10.3 MB
3. 시간: 0.06 ms, 메모리: 10.4 MB
4. 시간: 0.06 ms, 메모리: 10.3 MB
5. 시간: 0.06 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 05일 (화) 23:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges