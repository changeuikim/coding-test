# [Lv.1] [제일 작은 수 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12935?language=python3) - 12935 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(arr):    
    minNum = min(arr)
    return [num for num in arr if num > minNum] or [-1]
```

### 성능 요약

1. 시간: 2.01 ms, 메모리: 15.9 MB

2. 시간: 0.07 ms, 메모리: 10.4 MB
3. 시간: 0.05 ms, 메모리: 10.3 MB
4. 시간: 0.04 ms, 메모리: 10.3 MB
5. 시간: 0.04 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 02일 (토) 20:31

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges