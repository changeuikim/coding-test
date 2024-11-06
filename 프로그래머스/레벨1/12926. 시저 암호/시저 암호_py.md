# [Lv.1] [시저 암호](https://school.programmers.co.kr/learn/courses/30/lessons/12926?language=python3) - 12926 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(s, n):
    result = []
    
    for c in s:
        if c.isupper():
            result.append(chr((ord(c) - ord('A') + n) % 26 + ord('A')))
        elif c.islower():
            result.append(chr((ord(c) - ord('a') + n) % 26 + ord('a')))
        else:
            result.append(c)
    
    return ''.join(result)
```

### 성능 요약

1. 시간: 2.27 ms, 메모리: 10.2 MB

2. 시간: 0.02 ms, 메모리: 10.3 MB
3. 시간: 0.02 ms, 메모리: 10.2 MB
4. 시간: 0.02 ms, 메모리: 10.2 MB
5. 시간: 0.02 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 06일 (수) 19:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges