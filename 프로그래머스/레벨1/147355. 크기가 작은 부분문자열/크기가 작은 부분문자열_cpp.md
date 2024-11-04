# [Lv.1] [크기가 작은 부분문자열](https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=cpp) - 147355 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

int solution(string t, string p) {
    int cnt = 0;
    for (int i = 0; i < t.length() - p.length() + 1; i++) {
        string window = t.substr(i, p.length());
        if (window <= p) {
            cnt++;
        }
    }
    return cnt;
}
```

### 성능 요약

1. 시간: 0.13 ms, 메모리: 4.21 MB

2. 시간: 0.13 ms, 메모리: 4.21 MB
3. 시간: 0.13 ms, 메모리: 3.7 MB
4. 시간: 0.12 ms, 메모리: 4.18 MB
5. 시간: 0.11 ms, 메모리: 4.14 MB

### 제출 일자

2024년 11월 04일 (월) 21:32

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges