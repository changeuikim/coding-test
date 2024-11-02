# [Lv.1] [문자열 내림차순으로 배치하기](https://school.programmers.co.kr/learn/courses/30/lessons/12917?language=cpp) - 12917 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <algorithm>

using namespace std;

string solution(string s) {
    sort(s.rbegin(), s.rend());
    return s;
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 3.66 MB

2. 시간: 0.01 ms, 메모리: 4.22 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.2 MB
5. 시간: 0.01 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 02일 (토) 22:42

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges