# [Lv.1] [행렬의 덧셈](https://school.programmers.co.kr/learn/courses/30/lessons/12950?language=cpp) - 12950 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    for (int i = 0; i < arr1.size(); i++) {
        for (int j = 0; j <arr1[0].size(); j++) {
            arr1[i][j] += arr2[i][j];
        }
    }
    return arr1;
}
```

### 성능 요약

1. 시간: 60.44 ms, 메모리: 74.8 MB

2. 시간: 1.91 ms, 메모리: 5.28 MB
3. 시간: 1.91 ms, 메모리: 5.06 MB
4. 시간: 1.55 ms, 메모리: 5.33 MB
5. 시간: 1.16 ms, 메모리: 5.23 MB

### 제출 일자

2024년 11월 03일 (일) 21:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges