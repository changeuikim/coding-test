# [Lv.2] [타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=cpp) - 43165 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

int dfs(int idx, int curSum, int maxSum, const vector<int>& numbers, int target) {
    // 베이스 케이스 Base Case
    if (idx == numbers.size()) {
        return curSum == target ? 1 : 0;
    }

    // 가지치기 Pruning
    if (target > curSum + maxSum || target < curSum - maxSum) {
        return 0;
    }
    maxSum -= numbers[idx];

    // 재귀 Recursion
    return dfs(idx + 1, curSum - numbers[idx], maxSum, numbers, target) +
           dfs(idx + 1, curSum + numbers[idx], maxSum, numbers, target);
}

int solution(vector<int> numbers, int target) {
    int maxSum = 0;
    for (int num : numbers) {
        maxSum += num;
    }
    return dfs(0, 0, maxSum, numbers, target);
}
```

### 성능 요약

1. 시간: 2.71 ms, 메모리: 4.14 MB

2. 시간: 2.15 ms, 메모리: 4.21 MB
3. 시간: 0.07 ms, 메모리: 3.65 MB
4. 시간: 0.04 ms, 메모리: 3.68 MB
5. 시간: 0.01 ms, 메모리: 4.22 MB

### 제출 일자

2024년 11월 08일 (금) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges