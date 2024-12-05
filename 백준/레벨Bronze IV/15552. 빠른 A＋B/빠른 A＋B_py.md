# [Bronze IV] [빠른 A+B](https://www.acmicpc.net/problem/15552) - 15552 

NaN구현, 사칙연산, 수학

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline
T = int(input())

for _ in range(T):
    a, b = map(int, input().split())
    print(a+b)
```

### 성능 요약

시간: 416 ms

메모리: 116144 KB

### 제출 일자

2024년 12월 05일 (목) 16:53

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

