# [Lv.0] [수열과 구간 쿼리 2](https://school.programmers.co.kr/learn/courses/30/lessons/181923?language=python3) - 181923 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(arr, queries):
    result = [-1] * len(queries)
    for idx, (s, e, k) in enumerate(queries):
        temp = [x for x in arr[s : e + 1] if x > k]
        if temp:
            result[idx] = min(temp)
    return result
    
    
```

### 성능 요약

1. 시간: 12.05 ms, 메모리: 10.2 MB

2. 시간: 6.86 ms, 메모리: 10.4 MB
3. 시간: 5.04 ms, 메모리: 10.4 MB
4. 시간: 3.97 ms, 메모리: 10.3 MB
5. 시간: 3.65 ms, 메모리: 10.3 MB

### 제출 일자

2024년 10월 20일 (일) 22:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges