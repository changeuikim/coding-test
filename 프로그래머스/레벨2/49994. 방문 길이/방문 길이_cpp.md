# [Lv.2] [방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994?language=cpp) - 49994 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## C++ 문제풀이

```cpp
#include <string>
#include <map>
#include <algorithm>
#include <set>
#include <vector>


using namespace std;

int solution(string dirs) {
    // 방향 설정, 방문 기록, 초기 위치
    map<char, pair<int, int>> directions = {
        {'U', {0, 1}},
        {'D', {0, -1}},
        {'R', {1, 0}},
        {'L', {-1, 0}}
    };
    set<vector<pair<int, int>>> visited;
    int x = 0, y = 0;
    
    // 방향 전환 및 이동 처리
    for (char d : dirs) {
        int dx = directions[d].first;
        int dy = directions[d].second;
        int nx = x + dx;
        int ny = y + dy;
        
        if (-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
            // 작은 좌표를 항상 시작점으로 정렬
            vector<pair<int, int>> path = {{x, y}, {nx, ny}};
            sort(path.begin(), path.end());
            
            visited.insert(path);
            x = nx;
            y = ny;
        }
    }
    
    // 집합의 길이를 반환
    return visited.size();
}
```

### 성능 요약

1. 시간: 0.09 ms, 메모리: 4.21 MB

2. 시간: 0.09 ms, 메모리: 4.16 MB
3. 시간: 0.09 ms, 메모리: 4.14 MB
4. 시간: 0.08 ms, 메모리: 4.21 MB
5. 시간: 0.08 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 14일 (목) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges