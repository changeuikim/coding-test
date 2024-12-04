# [Lv.2] [가장 큰 수](https://programmers.co.kr/) - 42746 

### 구분

코딩테스트 연습 > 정렬

## Python 문제풀이

```py
from functools import cmp_to_key

def compare(x, y):
    left = x + y
    right = y + x
    
    if left > right:
        return -1
    elif left < right:
        return 1
    else:
        return 0

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=cmp_to_key(compare))
    return "0" if numbers[0] == "0" else "".join(numbers)
```

### 성능 요약

1. 시간: 318.22 ms, 메모리: 23.9 MB

2. 시간: 240.94 ms, 메모리: 18.3 MB
3. 시간: 230.41 ms, 메모리: 20.7 MB
4. 시간: 208.40 ms, 메모리: 19.5 MB
5. 시간: 127.54 ms, 메모리: 15.8 MB

### 제출 일자

2024년 12월 04일 (수) 23:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges