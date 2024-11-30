# [Lv.3] [단속카메라](https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=cpp) - 42884 

### 구분

코딩테스트 연습 > 탐욕법（Greedy）

## C++ 문제풀이

```cpp
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int camera = -30001;
    int result = 0;

    sort(routes.begin(), routes.end(), [](const vector<int>& a, const vector<int>& b) {
        return a[1] < b[1];
    });

    for (const auto& route : routes) {
        if (camera < route[0]) {
            result++;
            camera = route[1];
        }
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.50 ms, 메모리: 4.07 MB

2. 시간: 0.42 ms, 메모리: 4.12 MB
3. 시간: 0.19 ms, 메모리: 3.95 MB
4. 시간: 0.12 ms, 메모리: 3.82 MB
5. 시간: 0.03 ms, 메모리: 4.13 MB

### 제출 일자

2024년 11월 30일 (토) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges