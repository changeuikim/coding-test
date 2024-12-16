# [Gold III] [나머지 합](https://www.acmicpc.net/problem/10986) - 10986 

NaN수학, 누적 합

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def range_sum():
    # 누적 합 초기화
    N, M = map(int, input().split())
    nums = list(map(int, input().split()))

    pre = [0] * (N + 1)
    for i in range(N):
        pre[i + 1] = (pre[i] + nums[i]) % M
    
    # 나머지 배열 초기화
    r = [0] * M
    for i in range(1, N+1):
        r[pre[i]] += 1
    
    # 조합
    count = r[0] # 누적합도 구간합
    for i in range(M):
        count += (r[i] * (r[i]-1)) // 2 # nC2 = n * n-1 / 2

    print(count)

range_sum()
```

### 성능 요약

시간: 380 ms

메모리: 258096 KB

### 제출 일자

2024년 12월 16일 (월) 10:16

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

