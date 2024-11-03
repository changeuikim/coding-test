# [Lv.1] [행렬의 덧셈](https://school.programmers.co.kr/learn/courses/30/lessons/12950?language=python3) - 12950 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(arr1, arr2):    
    return [[col1 + col2 for col1, col2 in zip(row1, row2)] for row1, row2 in zip(arr1, arr2)]
```

### 성능 요약

1. 시간: 12.95 ms, 메모리: 23 MB

2. 시간: 0.89 ms, 메모리: 10.9 MB
3. 시간: 0.38 ms, 메모리: 10.5 MB
4. 시간: 0.35 ms, 메모리: 10.4 MB
5. 시간: 0.33 ms, 메모리: 10.8 MB

### 제출 일자

2024년 11월 03일 (일) 21:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges