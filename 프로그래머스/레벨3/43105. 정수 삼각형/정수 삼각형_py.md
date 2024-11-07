# [Lv.3] [정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=python3) - 43105 

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

## Python 문제풀이

```py
def solution(triangle):
    # bottom-up DP
    for row in range(len(triangle) - 2, -1, -1):
        for col in range(len(triangle[row])):
            left = triangle[row + 1][col]
            right = triangle[row + 1][col + 1]
            triangle[row][col] += left if left > right else right

    return triangle[0][0]
```

### 성능 요약

1. 시간: 29.74 ms, 메모리: 14.7 MB

2. 시간: 28.88 ms, 메모리: 14.6 MB
3. 시간: 27.99 ms, 메모리: 14.5 MB
4. 시간: 27.58 ms, 메모리: 14.5 MB
5. 시간: 25.60 ms, 메모리: 14.2 MB

### 제출 일자

2024년 11월 07일 (목) 23:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges