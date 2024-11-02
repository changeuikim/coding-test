# [Lv.1] [제일 작은 수 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12935?language=cpp) - 12935 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    auto minIt = min_element(arr.begin(), arr.end());
    arr.erase(minIt);
    
    if (arr.empty()) {
        arr.push_back(-1);
    }
    
    return arr;
}
```

### 성능 요약

1. 시간: 10.73 ms, 메모리: 13.3 MB

2. 시간: 0.20 ms, 메모리: 4.13 MB
3. 시간: 0.15 ms, 메모리: 4.21 MB
4. 시간: 0.13 ms, 메모리: 4.21 MB
5. 시간: 0.13 ms, 메모리: 4.16 MB

### 제출 일자

2024년 11월 02일 (토) 20:32

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges