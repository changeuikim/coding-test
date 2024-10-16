# [Lv.0] [문자열 곱하기](https://school.programmers.co.kr/learn/courses/30/lessons/181940?language=cpp) - 181940 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

string solution(string my_string, int k) {    
    string result;
    result.reserve(my_string.size() * k);
    while (k--) result += my_string;
    return result;
}
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 4.15 MB

2. 시간: 0.02 ms, 메모리: 4.21 MB
3. 시간: 0.02 ms, 메모리: 4.21 MB
4. 시간: 0.02 ms, 메모리: 4.13 MB
5. 시간: 0.02 ms, 메모리: 3.59 MB

### 제출 일자

2024년 10월 17일 (목) 01:36

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges