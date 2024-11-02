# [Lv.1] [부족한 금액 계산하기](https://school.programmers.co.kr/learn/courses/30/lessons/82612?language=python3) - 82612 

### 구분

코딩테스트 연습 > 위클리 챌린지

## Python 문제풀이

```py
def solution(price, money, count):
    cost = price * (1 + count) * count / 2
    result = money - cost    
    return max(0, -result)
```

### 성능 요약

1. 시간: 0.00 ms, 메모리: 10.4 MB

2. 시간: 0.00 ms, 메모리: 10.4 MB
3. 시간: 0.00 ms, 메모리: 10.4 MB
4. 시간: 0.00 ms, 메모리: 10.3 MB
5. 시간: 0.00 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 02일 (토) 22:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges