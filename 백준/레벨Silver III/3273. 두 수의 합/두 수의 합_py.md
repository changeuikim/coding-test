# [Silver III] [두 수의 합](https://www.acmicpc.net/problem/3273) - 3273 

NaN정렬, 두 포인터

## PyPy3 문제풀이

```PyPy3
n = int(input().rstrip())
arr = list(map(int, input().split()))
x = int(input().rstrip())

arr.sort()

cnt, i, j = 0, 0, n-1
while i < j:
    curr = arr[i] + arr[j]
    if curr < x:
        i += 1
    elif curr > x:
        j -= 1
    else:
        cnt += 1
        i += 1
        j -= 1

print(cnt)
```

### 성능 요약

시간: 112 ms

메모리: 121756 KB

### 제출 일자

2024년 12월 06일 (금) 23:40

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

