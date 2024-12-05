# [Bronze II] [숫자의 개수](https://www.acmicpc.net/problem/2577) - 2577 

NaN사칙연산, 구현, 수학

## PyPy3 문제풀이

```PyPy3
A = int(input())
B = int(input())
C = int(input())

digits = [0] * 10
number = A * B * C

while number:
    digits[number % 10] += 1
    number //= 10

for count in digits:
    print(count)
```

### 성능 요약

시간: 88 ms

메모리: 108080 KB

### 제출 일자

2024년 12월 05일 (목) 19:49

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

