# [Lv.1] [같은 숫자는 싫어](https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=cpp) - 12906 

### 구분

코딩테스트 연습 > 스택／큐

## C++ 문제풀이

```cpp
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    auto it = unique(arr.begin(), arr.end());
    arr.erase(it, arr.end());
    return arr;
}
```

### 성능 요약

1. 시간: 110.26 ms, 메모리: 105 MB

2. 시간: 109.36 ms, 메모리: 105 MB
3. 시간: 108.79 ms, 메모리: 105 MB
4. 시간: 108.78 ms, 메모리: 105 MB
5. 시간: 0.04 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 04일 (월) 19:40

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges