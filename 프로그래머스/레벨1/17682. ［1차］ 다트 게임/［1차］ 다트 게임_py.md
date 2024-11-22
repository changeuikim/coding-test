# [Lv.1] [[1차] 다트 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17682?language=python3) - 17682 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
import re

def solution(dartResult):
    bonus_map = { 'S' : 1, 'D' : 2, 'T' : 3 }
    option_map = { '*' : 2, '#' : -1, '' : 1 }
    scores = []
    
    # 점수 | 보너스 | [옵션]
    pattern = re.compile(r"(\d+)([SDT])([*#]?)")
    matches = pattern.findall(dartResult)

    for score_str, bonus, opt in matches:
        score = int(score_str) ** bonus_map[bonus] * option_map[opt]
        
        if opt == '*' and scores:
            scores[-1] *= option_map[opt]

        scores.append(score)
        
    return sum(scores)
```

### 성능 요약

1. 시간: 0.24 ms, 메모리: 10.2 MB

2. 시간: 0.24 ms, 메모리: 10 MB
3. 시간: 0.22 ms, 메모리: 10.2 MB
4. 시간: 0.21 ms, 메모리: 10.3 MB
5. 시간: 0.21 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 22일 (금) 23:30

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges