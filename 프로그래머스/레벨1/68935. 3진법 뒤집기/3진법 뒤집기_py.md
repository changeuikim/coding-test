# [Lv.1] [3진법 뒤집기](https://school.programmers.co.kr/learn/courses/30/lessons/68935?language=python3) - 68935 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## Python 문제풀이

```py
def solution(n):
    base_3 = []
    while n > 0:
        n, r = divmod(n, 3)
        base_3.append(r)
        
    return int(''.join(map(str, base_3)), 3)
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 10.3 MB

2. 시간: 0.03 ms, 메모리: 10.3 MB
3. 시간: 0.03 ms, 메모리: 10.2 MB
4. 시간: 0.03 ms, 메모리: 10.1 MB
5. 시간: 0.02 ms, 메모리: 10.5 MB

### 제출 일자

2024년 11월 05일 (화) 23:42

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges