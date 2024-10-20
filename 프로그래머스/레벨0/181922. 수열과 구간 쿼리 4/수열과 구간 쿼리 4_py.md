# [Lv.0] [수열과 구간 쿼리 4](https://school.programmers.co.kr/learn/courses/30/lessons/181922?language=python3) - 181922 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(arr, queries):
    for s, e, k in queries:
        for i in range(s, e + 1):
            if i % k == 0:
                arr[i] += 1
    return arr
            
```

### 성능 요약

1. 시간: 14.19 ms, 메모리: 10.2 MB

2. 시간: 9.48 ms, 메모리: 10.3 MB
3. 시간: 6.62 ms, 메모리: 10.2 MB
4. 시간: 6.22 ms, 메모리: 10.3 MB
5. 시간: 4.69 ms, 메모리: 10.3 MB

### 제출 일자

2024년 10월 20일 (일) 23:07

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges