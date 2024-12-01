# [Lv.2] [2개 이하로 다른 비트](https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=python3) - 77885 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## Python 문제풀이

```py
def solution(numbers):
    result = []
    
    for num in numbers:
        if num % 2 == 0:
            result.append(num + 1)
        else:
            bit = 1
            while num & bit:
                bit <<= 1
            result.append(num + bit - (bit >> 1))
    
    return result
```

### 성능 요약

1. 시간: 342.56 ms, 메모리: 23.8 MB

2. 시간: 340.41 ms, 메모리: 23.9 MB
3. 시간: 28.52 ms, 메모리: 23 MB
4. 시간: 28.23 ms, 메모리: 22.9 MB
5. 시간: 27.20 ms, 메모리: 22.4 MB

### 제출 일자

2024년 12월 01일 (일) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges