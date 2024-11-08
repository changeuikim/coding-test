# [Lv.3] [네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=python3) - 43162 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## Python 문제풀이

```py
def dfs(i, visited, computers):
    visited[i] = True
    for j in range(len(computers[i])):
        if not visited[j] and computers[i][j] == 1:
            dfs(j, visited, computers)

def solution(n, computers):
    visited = [False] * n
    count = 0
    
    for i in range(n):
        if not visited[i]:
            dfs(i, visited, computers)
            count += 1
    
    return count
    
    
```

### 성능 요약

1. 시간: 0.56 ms, 메모리: 10.4 MB

2. 시간: 0.34 ms, 메모리: 10.2 MB
3. 시간: 0.27 ms, 메모리: 10.3 MB
4. 시간: 0.18 ms, 메모리: 10.1 MB
5. 시간: 0.10 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 08일 (금) 22:44

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges