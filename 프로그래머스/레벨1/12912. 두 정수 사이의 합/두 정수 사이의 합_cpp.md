# [Lv.1] [두 정수 사이의 합](https://school.programmers.co.kr/learn/courses/30/lessons/12912?language=cpp) - 12912 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <utility>

using namespace std;

long long solution(int a, int b) {
    if (a > b) {
        swap(a, b);
    }
    
    long long result = 0;
    for (int i = a; i <= b; i++) {
        result += i;
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.23 MB

2. 시간: 0.01 ms, 메모리: 4.22 MB
3. 시간: 0.01 ms, 메모리: 4.22 MB
4. 시간: 0.01 ms, 메모리: 4.22 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 01일 (금) 18:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges