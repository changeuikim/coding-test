# [Lv.0] [문자 리스트를 문자열로 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/181941?language=cpp) - 181941 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <numeric>

using namespace std;

string solution(vector<string> arr) {
    return accumulate(arr.begin(), arr.end(), string(""));
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 4.11 MB

2. 시간: 0.04 ms, 메모리: 4.19 MB
3. 시간: 0.03 ms, 메모리: 4.21 MB
4. 시간: 0.03 ms, 메모리: 4.2 MB
5. 시간: 0.03 ms, 메모리: 4.15 MB

### 제출 일자

2024년 10월 17일 (목) 01:23

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges