# [Lv.1] [핸드폰 번호 가리기](https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=cpp) - 12948 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <regex>

using namespace std;

string solution(string phone_number) {
    return regex_replace(phone_number, regex("\\d(?=\\d{4})"), "*");
}
```

### 성능 요약

1. 시간: 0.15 ms, 메모리: 4.21 MB

2. 시간: 0.13 ms, 메모리: 4.21 MB
3. 시간: 0.13 ms, 메모리: 4.21 MB
4. 시간: 0.13 ms, 메모리: 4.21 MB
5. 시간: 0.12 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 02일 (토) 21:03

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges