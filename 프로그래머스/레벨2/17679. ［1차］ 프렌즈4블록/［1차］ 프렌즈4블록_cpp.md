# [Lv.2] [[1차] 프렌즈4블록](https://school.programmers.co.kr/learn/courses/30/lessons/17679?language=cpp) - 17679 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <utility>
#include <vector>
#include <string>
#include <unordered_set>

using namespace std;

struct pair_hash {
    template <class T1, class T2>
    size_t operator()(const pair<T1, T2>& p) const {
        return hash<T1>()(p.first) ^ (hash<T2>()(p.second) << 1);
    }
};

int solution(int m, int n, vector<string> board) {
    vector<vector<char>> blocks(m, vector<char>(n));
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            blocks[i][j] = board[i][j];
        }
    }
    int result = 0;

    while (true) {
        // 기능1: Pop 요소를 판별
        unordered_set<pair<int, int>, pair_hash> popSet;

        for (int i = 0; i < m - 1; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                char c = blocks[i][j];
                // 우측, 우하단, 하단
                if (c != ' ' && c == blocks[i][j + 1] && c == blocks[i + 1][j + 1] && c == blocks[i + 1][j]) {
                    popSet.insert({i, j});
                    popSet.insert({i, j + 1});
                    popSet.insert({i + 1, j + 1});                    
                    popSet.insert({i + 1, j});
                }
            }
        }

        // 기능2: 점수 업데이트
        if (popSet.empty()) {
            break;
        }

        result += popSet.size();

        // 기능3: 블록 내리기
        for (const auto& pos : popSet) {
            blocks[pos.first][pos.second] = ' ';
        }

        for (int j = 0; j < n; ++j) {
            int blankIdx = m - 1;

            for (int i = m - 1; i >= 0; --i) {
                if (blocks[i][j] != ' ') {
                    blocks[blankIdx][j] = blocks[i][j];
                    if (blankIdx != i) {
                        blocks[i][j] = ' ';
                    }
                    blankIdx--;
                }
            }
        }
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.45 ms, 메모리: 4.09 MB

2. 시간: 0.27 ms, 메모리: 3.7 MB
3. 시간: 0.21 ms, 메모리: 4.14 MB
4. 시간: 0.19 ms, 메모리: 4.14 MB
5. 시간: 0.18 ms, 메모리: 4.14 MB

### 제출 일자

2024년 11월 30일 (토) 23:44

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges