# [Lv.2] [숫자 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/154538?language=cpp) - 154538 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <unordered_map>
#include <queue>
#include <vector>

using namespace std;

int solution(int x, int y, int n) {
    if (x == y) {
        return 0;
    }

    unordered_map<int, int> dp;
    dp[y] = 0;
    queue<int> q;
    q.push(y);

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        // 종료 조건
        if (curr == x) {
            return dp[curr];
        }

        // 역방향 탐색
        vector<int> prevValues;

        if (curr - n >= x) {
            prevValues.push_back(curr - n);
        }
        if (curr % 2 == 0) {
            prevValues.push_back(curr / 2);
        }
        if (curr % 3 == 0) {
            prevValues.push_back(curr / 3);
        }

        // DP에 추가
        for (int prev : prevValues) {
            if (dp.find(prev) == dp.end()) {
                dp[prev] = dp[curr] + 1;
                q.push(prev);
            }
        }
    }

    return -1;
}
```

### 성능 요약

1. 시간: 0.32 ms, 메모리: 4.45 MB

2. 시간: 0.24 ms, 메모리: 3.7 MB
3. 시간: 0.22 ms, 메모리: 4.2 MB
4. 시간: 0.14 ms, 메모리: 4.21 MB
5. 시간: 0.14 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 27일 (수) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges