# [Lv.2] [땅따먹기](https://school.programmers.co.kr/learn/courses/30/lessons/12913?language=cpp) - 12913 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int> > land) {
    int n = land.size();
    int m = 4;
    
    // 2행부터 DP
    for (int i = 1; i < n; i++) {
        int max1 = -1, idx = -1, max2 = -1;
        
        // 이전 행의 최대, 차대 찾기
        for (int j = 0; j < m; j++) {
            int cur = land[i - 1][j];
            
            if (cur > max1) {
                max2 = max1;
                max1 = cur;
                idx = j;                
            }
            else if (cur > max2) {
                max2 = cur;
            }
        }
        
        // 이번 행 DP
        for (int j = 0; j < m; j++) {
            int prev = max1;
            if (j == idx) {
                prev = max2;
            }
            
            land[i][j] += prev;
        }
    }
    
    return *max_element(land[n - 1].begin(), land[n - 1].end());
}
```

### 성능 요약

1. 시간: 6.15 ms, 메모리: 25.8 MB

2. 시간: 5.96 ms, 메모리: 26.1 MB
3. 시간: 5.87 ms, 메모리: 26.1 MB
4. 시간: 5.74 ms, 메모리: 25.8 MB
5. 시간: 0.13 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 18일 (월) 22:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges