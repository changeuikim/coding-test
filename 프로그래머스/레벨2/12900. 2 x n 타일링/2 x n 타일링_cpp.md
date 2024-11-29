# [Lv.2] [2 x n 타일링](https://school.programmers.co.kr/learn/courses/30/lessons/12900?language=cpp) - 12900 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

int solution(int n) {
    const int MOD = 1000000007;

    // 빠른 반환
    if (n == 1 || n == 2) {
        return n;
    }

    // DP 초기화
    vector<int> dp(n + 1, 0);
    dp[1] = 1;
    dp[2] = 2;

    // DP 점화식
    for (size_t i = 3; i <= n; ++i) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }

    return dp[n];
}
```

### 성능 요약

1. 시간: 0.31 ms, 메모리: 3.8 MB

2. 시간: 0.21 ms, 메모리: 3.79 MB
3. 시간: 0.15 ms, 메모리: 3.86 MB
4. 시간: 0.11 ms, 메모리: 3.82 MB
5. 시간: 0.11 ms, 메모리: 3.8 MB

### 제출 일자

2024년 11월 29일 (금) 22:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges