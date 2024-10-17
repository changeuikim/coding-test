# [Lv.0] [코드 처리하기](https://school.programmers.co.kr/learn/courses/30/lessons/181932?language=python3) - 181932 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(code):
    mode = 0
    ret = ""
    
    for idx in range(len(code)):
        if code[idx] == "1":
            mode ^= 1
        else:
            if idx&1 == mode:
                ret += code[idx]
    
    return ret if ret else "EMPTY"
```

### 성능 요약

1. 시간: 18.35 ms, 메모리: 10.3 MB

2. 시간: 12.65 ms, 메모리: 10.1 MB
3. 시간: 11.82 ms, 메모리: 10.3 MB
4. 시간: 10.77 ms, 메모리: 10.2 MB
5. 시간: 9.86 ms, 메모리: 10.3 MB

### 제출 일자

2024년 10월 18일 (금) 08:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges