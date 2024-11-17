# [Lv.2] [뒤에 있는 큰 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/154539) - 154539 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(numbers):
    result = [-1] * len(numbers)
    stack = []
    
    for i, num in enumerate(numbers):
        while stack and num > numbers[stack[-1]]:
            result[stack.pop()] = num
        stack.append(i)

    return result
```

### 성능 요약

1. 시간: 283.14 ms, 메모리: 74.8 MB

2. 시간: 282.21 ms, 메모리: 75.5 MB
3. 시간: 255.85 ms, 메모리: 75.4 MB
4. 시간: 255.00 ms, 메모리: 75.4 MB
5. 시간: 252.54 ms, 메모리: 75.4 MB

### 제출 일자

2024년 11월 17일 (일) 23:47

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges