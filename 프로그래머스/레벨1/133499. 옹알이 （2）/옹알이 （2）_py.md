# [Lv.1] [옹알이 (2)](https://school.programmers.co.kr/learn/courses/30/lessons/133499?language=python3) - 133499 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
import re

def solution(babbling):
    # 전방탐색(lookahead)
    words = ['aya', 'ye', 'woo', 'ma']
    look_ahead = "|".join(f'{word}(?!{word})' for word in words)
    pattern = re.compile(f"^({look_ahead})+$")
    
    # 정규식
    count = 0
    for word in babbling:
        if pattern.match(word):
            count += 1
    
    return count
    
```

### 성능 요약

1. 시간: 0.33 ms, 메모리: 10.2 MB

2. 시간: 0.32 ms, 메모리: 10.1 MB
3. 시간: 0.31 ms, 메모리: 10.2 MB
4. 시간: 0.29 ms, 메모리: 10.3 MB
5. 시간: 0.27 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 09일 (토) 22:34

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges