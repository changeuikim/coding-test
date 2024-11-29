# [Lv.1] [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=python3) - 42576 

### 구분

코딩테스트 연습 > 해시

## Python 문제풀이

```py
def solution(participant, completion):
    hash_map = dict()
    for p in participant:
        if p not in hash_map:
            hash_map[p] = 1
        else:
            hash_map[p] += 1

    for c in completion:
        hash_map[c] -= 1

    for key, value in hash_map.items():
        if value == 1:
            return key
```

### 성능 요약

1. 시간: 42.88 ms, 메모리: 33.9 MB

2. 시간: 39.99 ms, 메모리: 33.9 MB
3. 시간: 34.29 ms, 메모리: 27.4 MB
4. 시간: 29.94 ms, 메모리: 25.1 MB
5. 시간: 19.95 ms, 메모리: 21.7 MB

### 제출 일자

2024년 11월 29일 (금) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges