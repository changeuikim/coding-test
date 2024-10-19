# [Lv.0] [수 조작하기 2](https://school.programmers.co.kr/learn/courses/30/lessons/181925?language=python3) - 181925 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(numLog):
    ops = { 1 : "w" , -1 : "s", 10: "d", -10:  "a" }
    controls = [0] * (len(numLog) -1)
    
    for i in range(len(numLog) - 1):
        key = numLog[i + 1] - numLog[i]
        controls[i] = ops[key]
    
    return "".join(controls)
        
        
    
```

### 성능 요약

1. 시간: 27.85 ms, 메모리: 14.4 MB

2. 시간: 20.99 ms, 메모리: 13.2 MB
3. 시간: 14.33 ms, 메모리: 12.1 MB
4. 시간: 13.87 ms, 메모리: 13.7 MB
5. 시간: 13.73 ms, 메모리: 13.8 MB

### 제출 일자

2024년 10월 19일 (토) 23:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges