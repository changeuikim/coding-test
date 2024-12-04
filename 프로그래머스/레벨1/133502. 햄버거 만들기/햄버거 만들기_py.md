# [Lv.1] [햄버거 만들기](https://programmers.co.kr/) - 133502 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(ingredient):
    stack = [0] * len(ingredient)
    top = -1
    result = 0
    
    for item in ingredient:
        top += 1
        stack[top] = item
        
        if top >= 3:
            if stack[top] == 1 and stack[top - 1] == 3 and stack[top - 2] == 2 and stack[top - 3] == 1:
                top -= 4
                result += 1
    
    return result
```

### 성능 요약

1. 시간: 158.26 ms, 메모리: 25.1 MB

2. 시간: 138.98 ms, 메모리: 22.4 MB
3. 시간: 114.31 ms, 메모리: 18.9 MB
4. 시간: 100.68 ms, 메모리: 17.4 MB
5. 시간: 96.03 ms, 메모리: 16.9 MB

### 제출 일자

2024년 12월 04일 (수) 22:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges