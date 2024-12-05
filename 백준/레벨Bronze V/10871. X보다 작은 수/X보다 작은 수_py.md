# [Bronze V] [X보다 작은 수](https://www.acmicpc.net/problem/10871) - 10871 

NaN구현

## PyPy3 문제풀이

```PyPy3
N, X = map(int, input().split())
A = map(int, input().split())

print(" ".join(str(a) for a in A if a < X))
```

### 성능 요약

시간: 104 ms

메모리: 111388 KB

### 제출 일자

2024년 12월 05일 (목) 09:01

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

