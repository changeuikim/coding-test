# [Lv.1] [[PCCE 기출문제] 9번 / 지폐 접기](https://school.programmers.co.kr/learn/courses/30/lessons/340199?language=python3) - 340199 

### 구분

코딩테스트 연습 > PCCE 기출문제

## Python 문제풀이

```py
def solution(wallet, bill):
    wallet.sort()
    bill.sort()
    count = 0
    
    while bill[0] > wallet[0] or bill[1] > wallet[1]:
        bill[1] //= 2
        bill.sort()
        count += 1
    
    return count
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 10.2 MB

2. 시간: 0.01 ms, 메모리: 10.2 MB
3. 시간: 0.01 ms, 메모리: 10.2 MB
4. 시간: 0.01 ms, 메모리: 10.1 MB
5. 시간: 0.01 ms, 메모리: 10.1 MB

### 제출 일자

2024년 11월 21일 (목) 23:44

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges