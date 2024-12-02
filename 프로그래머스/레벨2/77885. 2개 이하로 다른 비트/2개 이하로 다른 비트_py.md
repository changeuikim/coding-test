# [Lv.2] [2개 이하로 다른 비트](https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=python3) - 77885 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## Python 문제풀이

```py
def solution(numbers):
    result = []
    
    for num in numbers:
        # 첫번째 0은 1로, 뒤는 모두 0
        bigger_num = num + 1
        
        # 첫번째 0 이전은 0, 뒤는 모두 1
        bit_diff = (num ^ (num + 1))
        
        # 우측 시프트 시에 첫번째 01을 10으로 바꾸는 효과
        min_num = bigger_num + (bit_diff >> 2)
        
        result.append(min_num)
        
    return result
```

### 성능 요약

1. 시간: 27.42 ms, 메모리: 22.8 MB

2. 시간: 22.48 ms, 메모리: 25.3 MB
3. 시간: 22.32 ms, 메모리: 25.3 MB
4. 시간: 20.41 ms, 메모리: 23.3 MB
5. 시간: 19.99 ms, 메모리: 23.7 MB

### 제출 일자

2024년 12월 02일 (월) 19:37

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges