# [Lv.2] [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335) - 92335 

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
def convert_to_base(num: int, base: int) -> str:
    digits = "01234567890"
    result = []
    
    while num > 0:
        result.append(digits[num % base])
        num //= base
    
    return "".join(reversed(result))

def is_prime(num: int) -> bool:
    if num < 2:
        return False
    if num == 2 or num == 3:
        return True
    if num % 2 == 0 or num % 3 == 0:
        return False

    for i in range(5, int(num ** 0.5) + 1, 6):
        if num % i == 0:
            return False
    
    return True

def solution(n, k):
    k_num = convert_to_base(n, k)
    cnt = 0
    
    for num in k_num.split("0"):
        if num and is_prime(int(num)):
            cnt += 1
    
    return cnt
```

### 성능 요약

1. 시간: 16.81 ms, 메모리: 10.3 MB

2. 시간: 0.04 ms, 메모리: 10.5 MB
3. 시간: 0.04 ms, 메모리: 10.4 MB
4. 시간: 0.04 ms, 메모리: 10.4 MB
5. 시간: 0.04 ms, 메모리: 10.4 MB

### 제출 일자

2024년 11월 15일 (금) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges