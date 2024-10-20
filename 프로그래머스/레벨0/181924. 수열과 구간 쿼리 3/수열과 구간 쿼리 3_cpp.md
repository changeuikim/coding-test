# [Lv.0] [수열과 구간 쿼리 3](https://school.programmers.co.kr/learn/courses/30/lessons/181924?language=cpp) - 181924 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (const auto& query : queries) {
        int u = query[0];
        int v = query[1];
        swap(arr[u], arr[v]);
    }
    return arr;
}
```

### 성능 요약

1. 시간: 0.29 ms, 메모리: 4.22 MB

2. 시간: 0.21 ms, 메모리: 4.04 MB
3. 시간: 0.20 ms, 메모리: 4.01 MB
4. 시간: 0.19 ms, 메모리: 4.17 MB
5. 시간: 0.16 ms, 메모리: 3.89 MB

### 제출 일자

2024년 10월 20일 (일) 22:09

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges