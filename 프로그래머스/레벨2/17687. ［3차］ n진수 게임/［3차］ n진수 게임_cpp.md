# [Lv.2] [[3차] n진수 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17687?language=cpp) - 17687 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <string>
#include <sstream>
#include <deque>

using namespace std;

string base_converter(int number, int base) {
    const string chars = "0123456789ABCDEF";
    if (number == 0) return "0";
    
    string res;
    while (number > 0) {
        res = chars[number % base] + res;
        number /= base;
    }
    return res;
}

string solution(int n, int t, int m, int p) {
    string res = "";
    deque<char> seq;
    int num = 0;

    while (res.length() < t) {
        if (seq.size() >= m) {
            res += seq[p - 1];
            for (int i = 0; i < m; ++i) seq.pop_front();
        } else {
            string converted = base_converter(num++, n);
            for (char c : converted) {
                seq.push_back(c);
            }
        }
    }

    return res;
}

```

### 성능 요약

1. 시간: 5.49 ms, 메모리: 4.21 MB

2. 시간: 3.55 ms, 메모리: 4.16 MB
3. 시간: 2.85 ms, 메모리: 3.64 MB
4. 시간: 1.39 ms, 메모리: 3.65 MB
5. 시간: 1.31 ms, 메모리: 3.68 MB

### 제출 일자

2024년 11월 11일 (월) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges