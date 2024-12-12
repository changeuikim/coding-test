# [Gold V] [배](https://www.acmicpc.net/problem/1092) - 1092 

NaN그리디 알고리즘, 정렬

## PyPy3 문제풀이

```PyPy3
from sys import stdin
import math

input = stdin.readline

# 입력 처리
N = int(input().rstrip())
cranes = list(map(int, input().split()))
M = int(input().rstrip())
boxes = list(map(int, input().split()))

# 내림차순 정렬
cranes.sort(reverse=True)
boxes.sort(reverse=True)

if boxes[0] > cranes[0]:
    print(-1)
else:
    # 최소 시간 : 모든 박스 / 모든 크레인
    max_time = math.ceil(M / N)
    b_idx = 0

    for c_idx in range(1, N):
        # 현재 crane이 들 수 있는 가장 큰 box를 확인
        while b_idx < M and cranes[c_idx] < boxes[b_idx]:
            b_idx += 1

        # 해당 박스 범위 / 해당 크레인 범위
        cur_time = math.ceil(b_idx / c_idx)
        max_time = max(max_time, cur_time)

        if b_idx == M:
            break
    
    print(max_time)
```

### 성능 요약

시간: 88 ms

메모리: 109544 KB

### 제출 일자

2024년 12월 12일 (목) 17:57

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

