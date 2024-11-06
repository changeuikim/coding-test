# [Lv.1] [최소직사각형](https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=python3) - 86491 

### 구분

코딩테스트 연습 > 완전탐색

## Python 문제풀이

```py
def solution(sizes):
    w_max, h_max = 0, 0
    
    for width, height in sizes:        
        if width > height:
            width, height = height, width
        
        w_max = max(w_max, width)
        h_max = max(h_max, height)
    
    return w_max * h_max
```

### 성능 요약

1. 시간: 3.11 ms, 메모리: 11.4 MB

2. 시간: 2.73 ms, 메모리: 10.7 MB
3. 시간: 2.69 ms, 메모리: 11.1 MB
4. 시간: 2.31 ms, 메모리: 10.8 MB
5. 시간: 1.65 ms, 메모리: 10.4 MB

### 제출 일자

2024년 11월 06일 (수) 19:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges