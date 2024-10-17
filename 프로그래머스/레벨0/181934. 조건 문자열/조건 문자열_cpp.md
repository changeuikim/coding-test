# [Lv.0] [조건 문자열](https://school.programmers.co.kr/learn/courses/30/lessons/181934?language=cpp) - 181934 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

int solution(string ineq, string eq, int n, int m) {
    if (ineq == ">" && eq == "=") {
        return n >= m;
    }    
    else if (ineq == ">" && eq == "!") {
        return n > m;
    }
    else if (ineq == "<" && eq == "=") {
        return n <= m;
    }    
    else if (ineq == "<" && eq == "!") {
        return n < m;
    }
    return 0;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.23 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.2 MB

### 제출 일자

2024년 10월 18일 (금) 01:21

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges