# [Lv.2] [택배상자](https://school.programmers.co.kr/learn/courses/30/lessons/131704?language=python3) - 131704 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(order):
    head = 0
    stack = []
    
    for box in range(1, len(order) + 1):
        if box == order[head]:
            head += 1
        else:
            stack.append(box)
            
        while stack and stack[-1] == order[head]:
            stack.pop()
            head += 1
    
    return head
```

### 성능 요약

1. 시간: 175.32 ms, 메모리: 94.5 MB

2. 시간: 172.25 ms, 메모리: 53.1 MB
3. 시간: 156.83 ms, 메모리: 46.3 MB
4. 시간: 114.48 ms, 메모리: 66.3 MB
5. 시간: 101.49 ms, 메모리: 52.8 MB

### 제출 일자

2024년 11월 24일 (일) 23:21

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges