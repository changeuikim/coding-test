# [Lv.0] [수열과 구간 쿼리 4](https://school.programmers.co.kr/learn/courses/30/lessons/181922?language=cpp) - 181922 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (const auto& query : queries) {
        int s = query[0];
        int e = query[1];
        int k = query[2];

        for (int i = s; i <= e; i++) {
            if (i % k == 0) {
                arr[i] += 1;
            }
        }
    }
    return arr;
}
```

### 성능 요약

1. 시간: 0.85 ms, 메모리: 4.21 MB

2. 시간: 0.84 ms, 메모리: 4.15 MB
3. 시간: 0.54 ms, 메모리: 4.16 MB
4. 시간: 0.51 ms, 메모리: 3.88 MB
5. 시간: 0.48 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 20일 (일) 23:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges