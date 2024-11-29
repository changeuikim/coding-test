# [Lv.3] [숫자 게임](https://school.programmers.co.kr/learn/courses/30/lessons/12987?language=python3) - 12987 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Python 문제풀이

```py
def solution(A, B):
    A.sort()
    B.sort()
    
    result = 0    
    i = 0    
    
    for j in range(len(B)):
        if B[j] > A[i]:
            result += 1
            i += 1
    
    return result
```

### 성능 요약

1. 시간: 41.73 ms, 메모리: 18.6 MB

2. 시간: 40.13 ms, 메모리: 18.2 MB
3. 시간: 39.76 ms, 메모리: 18.2 MB
4. 시간: 2.99 ms, 메모리: 10.5 MB
5. 시간: 2.53 ms, 메모리: 10.5 MB

### 제출 일자

2024년 11월 29일 (금) 23:38

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges