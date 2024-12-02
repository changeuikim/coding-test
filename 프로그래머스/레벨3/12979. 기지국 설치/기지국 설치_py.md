# [Lv.3] [기지국 설치](https://programmers.co.kr/) - 12979 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Python 문제풀이

```py
import math

def solution(n, stations, w):    
    cover = 2 * w + 1
    result = 0
    
    # 좌측 끝 처리
    left = stations[0] - 1 - w
    if left > 0:
        result += math.ceil(left / cover)
    
    # 중간 구간 처리
    start = stations[0]
    for i in range(1, len(stations)):
        end = stations[i]
        mid = end - start - cover
        if mid > 0:
            result += math.ceil(mid / cover)
            
        start = end
            
    # 우측 끝 처리
    right = n - stations[-1] - w
    if right > 0:
        result += math.ceil(right / cover)
    
    return result
```

### 성능 요약

1. 시간: 1.84 ms, 메모리: 10.4 MB

2. 시간: 1.72 ms, 메모리: 10.5 MB
3. 시간: 1.64 ms, 메모리: 10.5 MB
4. 시간: 1.55 ms, 메모리: 10.4 MB
5. 시간: 0.01 ms, 메모리: 10.4 MB

### 제출 일자

2024년 12월 02일 (월) 23:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges