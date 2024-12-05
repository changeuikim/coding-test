# [Bronze V] [윤년](https://www.acmicpc.net/problem/2753) - 2753 

NaN구현, 사칙연산, 수학

## PyPy3 문제풀이

```PyPy3
year = int(input())

result = (year % 4 == 0 and year % 100 != 0) or year % 400 == 0

print(1 if result else 0)
```

### 성능 요약

시간: 92 ms

메모리: 108080 KB

### 제출 일자

2024년 12월 05일 (목) 13:06

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

