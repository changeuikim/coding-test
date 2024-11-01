# [Lv.1] [정수 내림차순으로 배치하기](https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=cpp) - 12933 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    string digits = to_string(n);
    sort(digits.rbegin(), digits.rend());
    return stoll(digits);
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.22 MB

2. 시간: 0.02 ms, 메모리: 4.17 MB
3. 시간: 0.02 ms, 메모리: 4.14 MB
4. 시간: 0.02 ms, 메모리: 3.76 MB
5. 시간: 0.02 ms, 메모리: 3.67 MB

### 제출 일자

2024년 11월 01일 (금) 21:21

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges