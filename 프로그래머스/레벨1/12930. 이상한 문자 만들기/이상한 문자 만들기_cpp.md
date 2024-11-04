# [Lv.1] [이상한 문자 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=cpp) - 12930 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

string solution(string s) {
    string result;
    result.reserve(s.size());
    int wordIdx = 0;
    
    for (char c : s) {
        if (c == ' ') {
            result += ' ';
            wordIdx = 0;
        } else {
            if (wordIdx % 2 == 0) {
                result += toupper(c);
            } else {
                result += tolower(c);
            }
            wordIdx++;
        }
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.2 MB

2. 시간: 0.02 ms, 메모리: 4.2 MB
3. 시간: 0.01 ms, 메모리: 4.22 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 04일 (월) 23:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges