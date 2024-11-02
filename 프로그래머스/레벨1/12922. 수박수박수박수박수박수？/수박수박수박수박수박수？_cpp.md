# [Lv.1] [수박수박수박수박수박수?](https://school.programmers.co.kr/learn/courses/30/lessons/12922?language=cpp) - 12922 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

string solution(int n) {
    string result = "";
    for (int i = 0; i < n; i++) {
        i & 1 ? result += "박" : result += "수";
    }
    return result;
}
```

### 성능 요약

1. 시간: 0.11 ms, 메모리: 4.16 MB

2. 시간: 0.06 ms, 메모리: 4.13 MB
3. 시간: 0.05 ms, 메모리: 4.16 MB
4. 시간: 0.04 ms, 메모리: 4.23 MB
5. 시간: 0.03 ms, 메모리: 3.68 MB

### 제출 일자

2024년 11월 02일 (토) 21:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges