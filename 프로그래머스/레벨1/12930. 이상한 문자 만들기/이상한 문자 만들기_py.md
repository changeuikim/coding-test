# [Lv.1] [이상한 문자 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=python3) - 12930 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(s):
    result = []
    word_idx = 0
    
    for char in s:
        if char == ' ':
            result.append(' ')
            word_idx = 0
        else:
            if word_idx % 2 == 0:
                result.append(char.upper())
            else:
                result.append(char.lower())
            word_idx += 1
    
    return ''.join(result)
```

### 성능 요약

1. 시간: 0.04 ms, 메모리: 10.1 MB

2. 시간: 0.03 ms, 메모리: 10.3 MB
3. 시간: 0.03 ms, 메모리: 10.3 MB
4. 시간: 0.03 ms, 메모리: 10.2 MB
5. 시간: 0.03 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 04일 (월) 23:26

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges