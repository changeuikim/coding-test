# [Lv.1] [자릿수 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=cpp) - 12931 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <iostream>

using namespace std;
int solution(int n) {
    int total = 0;
    
    // 일의 자리부터 자릿수 더하기
    while (n > 0) {
        total += n % 10;
        n /= 10;
    }
    
    return total;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.23 MB

2. 시간: 0.01 ms, 메모리: 4.22 MB
3. 시간: 0.01 ms, 메모리: 4.22 MB
4. 시간: 0.01 ms, 메모리: 4.22 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 30일 (수) 21:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges