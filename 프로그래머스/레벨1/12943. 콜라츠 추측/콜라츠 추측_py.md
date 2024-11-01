# [Lv.1] [콜라츠 추측](https://school.programmers.co.kr/learn/courses/30/lessons/12943?language=python3) - 12943 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(num):  
    cnt = 0
    
    while num != 1:
        if cnt == 500:
            return -1
        
        if num & 1 == 0:
            num //= 2
        else:
            num = 3 * num + 1
        
        cnt += 1
    
    return cnt
```

### 성능 요약

1. 시간: 0.14 ms, 메모리: 10.1 MB

2. 시간: 0.12 ms, 메모리: 10.2 MB
3. 시간: 0.09 ms, 메모리: 10.1 MB
4. 시간: 0.07 ms, 메모리: 10 MB
5. 시간: 0.05 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 01일 (금) 23:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges