# [Lv.0] [수 조작하기 1](https://school.programmers.co.kr/learn/courses/30/lessons/181926?language=cpp) - 181926 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <map>

using namespace std;

int solution(int n, string control) {
    map<char, int> ops = {{'w', 1}, {'s', -1}, {'d', 10}, {'a', -10}};
    
    for (char key : control) {
        n += ops[key];
    }
    
    return n;
}
```

### 성능 요약

1. 시간: 1.01 ms, 메모리: 4.2 MB

2. 시간: 0.99 ms, 메모리: 4.16 MB
3. 시간: 0.85 ms, 메모리: 3.78 MB
4. 시간: 0.82 ms, 메모리: 4.14 MB
5. 시간: 0.77 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 19일 (토) 21:13

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges