# [Lv.3] [단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=cpp) - 43163 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <algorithm> 
#include <queue>

using namespace std;

int solution(string begin, string target, vector<string> words) {
    if (find(words.begin(), words.end(), target) == words.end()) {
        return 0;
    }

    queue<pair<string, int>> q;
    q.push({begin, 0});
    vector<bool> visited(words.size(), false);

    while (!q.empty()) {
        auto [cur, cnt] = q.front();
        q.pop();

        // 종료 조건
        if (cur == target) {
            return cnt;
        }

        // 1글자만 다르면 큐에 추가
        for (int i = 0; i < words.size(); ++i) {
            if (visited[i]) { 
                continue;
            }

            // 자리별 차이 계산
            int dif = 0;
            for (int j = 0; j < begin.size(); ++j) {
                if (cur[j] != words[i][j]) {
                    dif++;
                }
                if (dif > 1) {
                    break;
                }
            }

            // 엔큐
            if (dif == 1) {
                visited[i] = true;
                q.push({words[i], cnt + 1});
            }
        }
    }

    return 0;
}

```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.15 MB

2. 시간: 0.01 ms, 메모리: 4.29 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.14 MB
5. 시간: 0.01 ms, 메모리: 3.68 MB

### 제출 일자

2024년 11월 20일 (수) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges