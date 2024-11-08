# [Lv.3] [네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=cpp) - 43162 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

void dfs(int i, vector<bool>& visited, const vector<vector<int>>& computers) {
    visited[i] = true;
    for (int j = 0; j < computers[i].size(); j++) {
        if (!visited[j] && computers[i][j] == 1) {
            dfs(j, visited, computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    vector<bool> visited(n, false);
    int count = 0;
    
    for (int i = 0; i < computers.size(); i++) {
        if (!visited[i]) {
            dfs(i, visited, computers);
            count++;
        }
    }

    return count;    
}
```

### 성능 요약

1. 시간: 0.07 ms, 메모리: 4.16 MB

2. 시간: 0.05 ms, 메모리: 4.16 MB
3. 시간: 0.04 ms, 메모리: 4.14 MB
4. 시간: 0.02 ms, 메모리: 4.2 MB
5. 시간: 0.02 ms, 메모리: 4.14 MB

### 제출 일자

2024년 11월 08일 (금) 22:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges