# [Lv.2] [모음 사전](https://school.programmers.co.kr/learn/courses/30/lessons/84512) - 84512 

### 구분

코딩테스트 연습 > 완전탐색

## Python 문제풀이

```py
def solution(word):
    dic = "AEIOU"
    acc = len(word)
    combs = 0
    for i in range(5):
        combs += 5 ** i

    for i, char in enumerate(word):
        acc += dic.index(char) * combs // (5 ** i)

    return acc

```

### 성능 요약

1. 시간: 0.59 ms, 메모리: 10.1 MB

2. 시간: 0.02 ms, 메모리: 10.3 MB
3. 시간: 0.02 ms, 메모리: 10.2 MB
4. 시간: 0.01 ms, 메모리: 10.3 MB
5. 시간: 0.01 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 16일 (토) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges