# [Lv.1] [같은 숫자는 싫어](https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=python3) - 12906 

### 구분

코딩테스트 연습 > 스택／큐

## Python 문제풀이

```py
def solution(arr):
    stack = [arr[0]]
    
    for num in arr:
        if num != stack[-1]:
            stack.append(num)

    return stack
```

### 성능 요약

1. 시간: 73.74 ms, 메모리: 27.8 MB

2. 시간: 72.75 ms, 메모리: 27.9 MB
3. 시간: 56.94 ms, 메모리: 27.8 MB
4. 시간: 53.89 ms, 메모리: 27.9 MB
5. 시간: 0.02 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 04일 (월) 19:39

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges