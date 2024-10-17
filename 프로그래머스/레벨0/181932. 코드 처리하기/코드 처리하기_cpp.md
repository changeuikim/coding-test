# [Lv.0] [코드 처리하기](https://school.programmers.co.kr/learn/courses/30/lessons/181932?language=cpp) - 181932 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

string solution(string code) {
    int mode = 0;
    string ret = "";
    
    for (int idx = 0; idx < code.length(); idx ++) {
        if (code[idx] == '1') {
            mode ^= 1;
        } else {
            if ((idx&1) == mode) {
                ret += code[idx];
            }
        }
    }
    return ret.length() > 0 ? ret : "EMPTY";
}

```

### 성능 요약

1. 시간: 0.30 ms, 메모리: 4.17 MB

2. 시간: 0.29 ms, 메모리: 3.82 MB
3. 시간: 0.27 ms, 메모리: 4.17 MB
4. 시간: 0.26 ms, 메모리: 4.22 MB
5. 시간: 0.22 ms, 메모리: 4.16 MB

### 제출 일자

2024년 10월 18일 (금) 08:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges