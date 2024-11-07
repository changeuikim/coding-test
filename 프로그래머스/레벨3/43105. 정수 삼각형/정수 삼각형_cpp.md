# [Lv.3] [정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=cpp) - 43105 

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    // bottom-up DP
    for (int row = triangle.size() - 2; row >= 0; row--) {
        for (int col = 0; col < triangle[row].size(); col++) {
            int left = triangle[row + 1][col];
            int right = triangle[row + 1][col + 1];
            triangle[row][col] += (left > right) ? left : right;
        }
    }
    return triangle[0][0];
}
```

### 성능 요약

1. 시간: 0.34 ms, 메모리: 8.3 MB

2. 시간: 0.34 ms, 메모리: 8.14 MB
3. 시간: 0.34 ms, 메모리: 7.73 MB
4. 시간: 0.32 ms, 메모리: 8.18 MB
5. 시간: 0.31 ms, 메모리: 7.25 MB

### 제출 일자

2024년 11월 07일 (목) 23:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges