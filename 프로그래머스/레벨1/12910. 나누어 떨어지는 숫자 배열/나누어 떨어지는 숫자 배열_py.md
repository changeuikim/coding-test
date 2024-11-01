# [Lv.1] [나누어 떨어지는 숫자 배열](https://school.programmers.co.kr/learn/courses/30/lessons/12910?language=python3) - 12910 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(arr, divisor):    
    result = sorted(i for i in arr if i % divisor == 0)
    return result or [-1]
    
```

### 성능 요약

1. 시간: 3.60 ms, 메모리: 13.4 MB

2. 시간: 0.36 ms, 메모리: 10.3 MB
3. 시간: 0.34 ms, 메모리: 10.4 MB
4. 시간: 0.22 ms, 메모리: 10.3 MB
5. 시간: 0.18 ms, 메모리: 10.4 MB

### 제출 일자

2024년 11월 01일 (금) 22:26

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges