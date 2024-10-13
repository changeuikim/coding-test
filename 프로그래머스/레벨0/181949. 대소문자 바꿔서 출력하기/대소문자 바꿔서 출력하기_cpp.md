# [Lv.0] [대소문자 바꿔서 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181949?language=cpp) - 181949 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <iostream>
#include <string>
#include <cctype>

using namespace std;

string swapcase(const string& str) {
    string result;
    for (char c : str) {
        if (isupper(c)) {
            result += tolower(c);
        } else {
            result += toupper(c);
        }
    }
    return result;
}

int main(void) {
    string str;
    cin >> str;
    
    cout << swapcase(str);
    
    return 0;
}
```

### 성능 요약

1. 시간: 5.04 ms, 메모리: 3.58 MB

2. 시간: 2.48 ms, 메모리: 4.13 MB
3. 시간: 2.02 ms, 메모리: 4.21 MB
4. 시간: 1.89 ms, 메모리: 4.15 MB

### 제출 일자

2024년 10월 13일 (일) 11:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges