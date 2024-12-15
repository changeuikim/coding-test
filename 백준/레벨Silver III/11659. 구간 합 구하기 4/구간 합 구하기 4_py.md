# [Silver III] [구간 합 구하기 4](https://www.acmicpc.net/problem/11659) - 11659 

NaN누적 합

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def range_sum():
    # 누적 합 초기화
    N, M = map(int, input().split())
    nums = list(map(int, input().split()))
    prefix_sum = [0] * (N + 1)

    for i in range(N):
        prefix_sum[i + 1] = prefix_sum[i] + nums[i]

    # 구간 합 출력
    for _ in range(M):
        i, j = map(int, input().split())
        print(prefix_sum[j] - prefix_sum[i - 1])

range_sum()
```

### 성능 요약

시간: 156 ms

메모리: 121588 KB

### 제출 일자

2024년 12월 16일 (월) 08:38

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

