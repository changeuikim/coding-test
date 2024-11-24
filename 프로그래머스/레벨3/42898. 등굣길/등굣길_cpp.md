# [Lv.3] [등굣길](https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=cpp#) - 42898 

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    const int MOD = 1000000007;
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
    
    dp[1][1] = 1;
    for (const auto& puddle : puddles) {
        int x = puddle[0];
        int y = puddle[1];
        dp[y][x] = -1;
    }

    for (int y = 1; y <= n; ++y) {
        for (int x = 1; x <= m; ++x) {
            if (dp[y][x] == -1) {
                dp[y][x] = 0;
            } else {
                dp[y][x] += (dp[y - 1][x] + dp[y][x - 1]) % MOD;
            }
        }
    }

    return dp[n][m];
}
```

### 성능 요약

1. 시간: 0.06 ms, 메모리: 3.89 MB

2. 시간: 0.06 ms, 메모리: 3.82 MB
3. 시간: 0.05 ms, 메모리: 3.8 MB
4. 시간: 0.05 ms, 메모리: 3.8 MB
5. 시간: 0.05 ms, 메모리: 3.8 MB

### 제출 일자

2024년 11월 24일 (일) 23:26

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges