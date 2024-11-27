# [Lv.1] [문자열 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/140108?language=python3) - 140108 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(s):
    x = None
    diff_count = 0
    result = 0
    
    for i in range(len(s)):
        # 문자열 구간 초기화
        if diff_count == 0:
            x = s[i]
            diff_count = 1
            result += 1
        # 현재 구간 상태 업데이트
        else:
            if x == s[i]:
                diff_count += 1
            else:
                diff_count -= 1
                
    return result
```

### 성능 요약

1. 시간: 1.73 ms, 메모리: 10.3 MB

2. 시간: 1.70 ms, 메모리: 10.2 MB
3. 시간: 1.51 ms, 메모리: 10.3 MB
4. 시간: 1.43 ms, 메모리: 10.2 MB
5. 시간: 1.09 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 27일 (수) 21:14

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges