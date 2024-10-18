# [Lv.0] [주사위 게임 2](https://school.programmers.co.kr/learn/courses/30/lessons/181930?language=python3) - 181930 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def calc(a, b, c, n):
    return pow(a, n) + pow(b, n) + pow(c, n)

def solution(a, b, c):
    dice_set = {a, b, c}
    result = 1
    
    if len(dice_set) <= 3:
        result *= calc(a, b, c, 1)
    if len(dice_set) <= 2:
        result *= calc(a, b, c, 2)
    if len(dice_set) == 1:
        result *= calc(a, b, c, 3)

    return result
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 10.2 MB

2. 시간: 0.01 ms, 메모리: 10.3 MB
3. 시간: 0.01 ms, 메모리: 10.3 MB
4. 시간: 0.01 ms, 메모리: 10.3 MB
5. 시간: 0.01 ms, 메모리: 10.3 MB

### 제출 일자

2024년 10월 18일 (금) 10:26

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges