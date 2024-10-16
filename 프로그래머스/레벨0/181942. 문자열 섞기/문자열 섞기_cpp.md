# [Lv.0] [문자열 섞기](https://school.programmers.co.kr/learn/courses/30/lessons/181942?language=cpp) - 181942 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

string solution(string str1, string str2) {
    size_t size = str1.size();
    string result = "";
    
    result.reserve(size * 2);
    
    for (size_t i = 0; i < size; i++) {
        result += str1[i];
        result += str2[i];
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.25 MB

2. 시간: 0.01 ms, 메모리: 4.23 MB
3. 시간: 0.01 ms, 메모리: 4.22 MB
4. 시간: 0.01 ms, 메모리: 4.22 MB
5. 시간: 0.01 ms, 메모리: 4.22 MB

### 제출 일자

2024년 10월 17일 (목) 01:07

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges