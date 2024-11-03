# [Lv.1] [문자열 다루기 기본](https://school.programmers.co.kr/learn/courses/30/lessons/12918?language=cpp) - 12918 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <regex>

using namespace std;

bool solution(string s) {    
    regex pattern(R"(^\d{4}$|^\d{6}$)");
    return regex_match(s, pattern);
}
```

### 성능 요약

1. 시간: 1.14 ms, 메모리: 4.21 MB

2. 시간: 0.23 ms, 메모리: 4.21 MB
3. 시간: 0.21 ms, 메모리: 4.15 MB
4. 시간: 0.20 ms, 메모리: 3.79 MB
5. 시간: 0.15 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 03일 (일) 21:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges