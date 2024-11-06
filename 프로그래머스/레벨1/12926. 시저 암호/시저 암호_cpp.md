# [Lv.1] [시저 암호](https://school.programmers.co.kr/learn/courses/30/lessons/12926?language=cpp) - 12926 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

string solution(string s, int n) {
    string result;
    
    for (char c : s) {
        if (c == ' ') {
            result += c;
        } else if (isupper(c)) {
            result += (char) ((c - 'A' + n) % 26 + 'A');
        } else {
            result += (char) ((c - 'a' + n) % 26 + 'a');
        }
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.11 ms, 메모리: 4.17 MB

2. 시간: 0.01 ms, 메모리: 4.23 MB
3. 시간: 0.01 ms, 메모리: 4.22 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 06일 (수) 19:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges