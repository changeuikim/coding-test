# [Bronze V] [시험 성적](https://www.acmicpc.net/problem/9498) - 9498 

NaN구현

## PyPy3 문제풀이

```PyPy3
score = int(input())
result = ""

if 90 <= score <= 100:
    result = "A"
elif 80 <= score:
    result = "B"
elif 70 <= score:
    result = "C"
elif 60 <= score:
    result = "D"
else:
    result = "F"

print(result)
```

### 성능 요약

시간: 92 ms

메모리: 108080 KB

### 제출 일자

2024년 12월 05일 (목) 11:04

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

