# [Lv.1] [두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=python3) - 68644 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## Python 문제풀이

```py
def solution(numbers):
    n_set = set()
    
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            n_set.add(numbers[i] + numbers[j])
            
    return sorted(n_set)
```

### 성능 요약

1. 시간: 0.51 ms, 메모리: 10.3 MB

2. 시간: 0.48 ms, 메모리: 10.1 MB
3. 시간: 0.43 ms, 메모리: 10.3 MB
4. 시간: 0.05 ms, 메모리: 10.1 MB
5. 시간: 0.01 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 06일 (수) 22:09

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges