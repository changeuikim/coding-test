# [Lv.0] [수열과 구간 쿼리 2](https://school.programmers.co.kr/learn/courses/30/lessons/181923?language=cpp) - 181923 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <climits>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> result(queries.size(), -1);

    for (int idx = 0; idx < queries.size(); idx++) {
        int s = queries[idx][0];
        int e = queries[idx][1];
        int k = queries[idx][2];

        int minVal = INT_MAX;

        for (int i = s; i <= e; i++) {
            if (arr[i] > k) {
                minVal = min(minVal, arr[i]);
            }
        }

        
        result[idx] = minVal == INT_MAX ? -1 : minVal;
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.31 ms, 메모리: 4.21 MB

2. 시간: 0.30 ms, 메모리: 3.76 MB
3. 시간: 0.28 ms, 메모리: 4.2 MB
4. 시간: 0.24 ms, 메모리: 4.16 MB
5. 시간: 0.19 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 20일 (일) 22:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges