# [Lv.1] [부족한 금액 계산하기](https://school.programmers.co.kr/learn/courses/30/lessons/82612?language=cpp) - 82612 

### 구분

코딩테스트 연습 > 위클리 챌린지

## C++ 문제풀이

```cpp
#include <algorithm>

using namespace std;

long long solution(int price, int money, int count) {
    long long cost = static_cast<long long>(price) * count * (count + 1) / 2;
    long long result = money - cost;
    return max(0LL, -result);
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.28 MB

2. 시간: 0.01 ms, 메모리: 4.23 MB
3. 시간: 0.01 ms, 메모리: 4.22 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 02일 (토) 22:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges