# [Lv.1] [둘만의 암호](https://school.programmers.co.kr/learn/courses/30/lessons/155652?language=python3) - 155652 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(s, skip, index):
    skip_set = set(skip)    
    result = []
    
    for char in s:
        shift_cnt = index
        c = char
        
        while shift_cnt > 0:
            c = 'a' if c == 'z' else chr(ord(c) + 1)
            if c not in skip_set:
                shift_cnt -= 1
        
        result.append(c)
        
    return ''.join(result)
```

### 성능 요약

1. 시간: 0.21 ms, 메모리: 10.1 MB

2. 시간: 0.19 ms, 메모리: 10.3 MB
3. 시간: 0.16 ms, 메모리: 10.3 MB
4. 시간: 0.14 ms, 메모리: 10.2 MB
5. 시간: 0.13 ms, 메모리: 10.1 MB

### 제출 일자

2024년 11월 28일 (목) 20:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges