# [Bronze V] [X보다 작은 수](https://www.acmicpc.net/problem/10871) - 10871 

NaN구현

## PyPy3 문제풀이

```PyPy3
from sys import stdin, stdout

lines = stdin.read().splitlines()

# 입력처리
N, X = map(int, lines[0].split())
A = map(int, lines[1].split())

# 출력처리
print(" ".join(str(a) for a in A if a < X))
```

### 성능 요약

시간: 104 ms

메모리: 111404 KB

### 제출 일자

2024년 12월 02일 (월) 21:49

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

