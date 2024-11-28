# [Lv.1] [대충 만든 자판](https://school.programmers.co.kr/learn/courses/30/lessons/160586?language=python3) - 160586 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
from collections import defaultdict

def solution(keymap, targets):
    # 키 사전 생성
    key_map = defaultdict(lambda: float('inf'))
    
    for key in keymap:
        for idx, ch in enumerate(key):    
            key_map[ch] = min(key_map[ch], idx + 1)

    # 결과 처리
    result = [0] * len(targets)            
            
    for idx, target in enumerate(targets):
        acc = 0
        for ch in target:
            if ch not in key_map:
                acc = -1
                break
            acc += key_map[ch]
        
        result[idx] = acc
    
    return result
```

### 성능 요약

1. 시간: 2.14 ms, 메모리: 10.2 MB

2. 시간: 1.24 ms, 메모리: 10.2 MB
3. 시간: 1.24 ms, 메모리: 10.1 MB
4. 시간: 1.11 ms, 메모리: 10.2 MB
5. 시간: 1.07 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 28일 (목) 23:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges