# [Lv.0] [원소들의 곱과 합](https://school.programmers.co.kr/learn/courses/30/lessons/181929?language=python3) - 181929 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
import math

def solution(num_list):
    product = math.prod(num_list)
    sum_square = pow(sum(num_list), 2)
    
    return 1 if product < sum_square else 0
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 10.2 MB

2. 시간: 0.00 ms, 메모리: 10.3 MB
3. 시간: 0.00 ms, 메모리: 10.3 MB
4. 시간: 0.00 ms, 메모리: 10.3 MB
5. 시간: 0.00 ms, 메모리: 10.3 MB

### 제출 일자

2024년 10월 18일 (금) 10:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges