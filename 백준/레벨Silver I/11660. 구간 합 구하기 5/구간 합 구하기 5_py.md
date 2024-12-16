# [Silver I] [구간 합 구하기 5](https://www.acmicpc.net/problem/11660) - 11660 

NaN다이나믹 프로그래밍, 누적 합

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def range_sum():
    # 누적 합 초기화
    N, M = map(int, input().split())

    nums = []
    for _ in range(N):
        nums.append(list(map(int, input().split())))

    pre = [[0] * (N + 1) for _ in range(N + 1)]
    for i in range(1, N+1):
        for j in range(1, N+1):
            pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + nums[i-1][j-1]
    
    # 구간 합 처리
    for _ in range(M):
        x1, y1, x2, y2 = map(int, input().split())

        t = pre[x2][y2] - pre[x1-1][y2] - pre[x2][y1-1] + pre[x1-1][y1-1]
        print(t)

range_sum()
```

### 성능 요약

시간: 316 ms

메모리: 129540 KB

### 제출 일자

2024년 12월 16일 (월) 09:29

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

