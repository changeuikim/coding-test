# [Lv.2] [게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=python3) - 1844 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## Python 문제풀이

```py
from collections import deque

def solution(maps):    
    # 초기화
    n, m = len(maps), len(maps[0])
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)] # 동서남북
    distance = [[1] * m for _ in range(n)] # 이동 칸 수
    queue = deque([(0, 0)]) # (y, x)
    
    # BFS    
    while queue:
        y, x = queue.popleft()
        
        # 종료 조건 : n행 m열
        if y == n - 1 and x == m - 1:
            return distance[y][x]
        
        # 방향전환
        for dy, dx in directions:
            ny, nx = y + dy, x + dx
            if 0 <= ny < n and 0 <= nx < m:
                if distance[ny][nx] == 1 and maps[ny][nx] == 1:
                    distance[ny][nx] = distance[y][x] + 1
                    queue.append((ny, nx))
            
    return -1
```

### 성능 요약

1. 시간: 9.35 ms, 메모리: 10.2 MB

2. 시간: 6.72 ms, 메모리: 10.3 MB
3. 시간: 4.37 ms, 메모리: 10.2 MB
4. 시간: 2.83 ms, 메모리: 10.4 MB
5. 시간: 0.09 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 09일 (토) 23:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges