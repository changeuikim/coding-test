# [Gold V] [회의실 배정](https://www.acmicpc.net/problem/1931) - 1931 

NaN그리디 알고리즘, 정렬

## PyPy3 문제풀이

```PyPy3
from sys import stdin

def greedy():
    N = int(input().rstrip())
    
    meetings = []
    for _ in range(N):
        line = list(map(int, input().split()))
        meetings.append(line)

    # 종료가 빠른 순으로 정렬
    meetings.sort(key=lambda x: (x[1], x[0]))

    E, cnt = -1, 0
    for ns, ne in meetings:
        # 현재 종료 <= 다음 시작
        if E <= ns:
            E = ne
            cnt += 1

    print(cnt)

greedy()
```

### 성능 요약

시간: 352 ms

메모리: 131208 KB

### 제출 일자

2024년 12월 22일 (일) 17:59

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

