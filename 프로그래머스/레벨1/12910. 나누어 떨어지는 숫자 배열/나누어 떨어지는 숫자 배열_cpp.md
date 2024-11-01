# [Lv.1] [나누어 떨어지는 숫자 배열](https://school.programmers.co.kr/learn/courses/30/lessons/12910?language=cpp) - 12910 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> result;
    for (int n : arr) {
        if (n % divisor == 0) {
            result.push_back(n);
        }
    }
    sort(result.begin(), result.end());
    return result.empty() ? vector<int>{-1} : result;
}
```

### 성능 요약

1. 시간: 0.39 ms, 메모리: 6.11 MB

2. 시간: 0.06 ms, 메모리: 4.17 MB
3. 시간: 0.04 ms, 메모리: 4.21 MB
4. 시간: 0.03 ms, 메모리: 4.21 MB
5. 시간: 0.03 ms, 메모리: 4.17 MB

### 제출 일자

2024년 11월 01일 (금) 22:29

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges