# [Lv.2] [게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=cpp) - 1844 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## C++ 문제풀이

```cpp
#include<vector>
#include<queue>
#include<utility>

using namespace std;

int solution(vector<vector<int> > maps) {
    // 초기화
    int n = maps.size();
    int m = maps[0].size();
    vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동서남북
    vector<vector<int>> distance(n, vector<int>(m, 1)); // 이동 칸 수
    queue<pair<int, int>> q;
    q.push({0, 0}); // (y, x)
    
    // BFS
    while (!q.empty()) {
        auto [y, x] = q.front();
        q.pop();
        
        // 종료 조건 : n행 m열
        if (y == n - 1 && x == m - 1) {
            return distance[y][x];
        }
        
        // 방향 전환
        for (auto [dy, dx] : directions) {
            int ny = y + dy;
            int nx = x + dx;
            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (distance[ny][nx] == 1 && maps[ny][nx] == 1) {
                    distance[ny][nx] = distance[y][x] + 1;
                    q.push({ny, nx});
                }
            }
        }
    }
    
    return -1;
} 
```

### 성능 요약

1. 시간: 0.30 ms, 메모리: 4.2 MB

2. 시간: 0.23 ms, 메모리: 4.16 MB
3. 시간: 0.21 ms, 메모리: 4.14 MB
4. 시간: 0.17 ms, 메모리: 4.09 MB
5. 시간: 0.01 ms, 메모리: 4.29 MB

### 제출 일자

2024년 11월 09일 (토) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges