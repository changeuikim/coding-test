# [Lv.0] [홀짝 구분하기](https://school.programmers.co.kr/learn/courses/30/lessons/181944?language=cpp) - 181944 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <iostream>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    cout << n << " is " << (n&1 == 1 ? "odd" : "even");
    return 0;
}
```

### 성능 요약

1. 시간: 2.14 ms, 메모리: 4.21 MB

2. 시간: 2.06 ms, 메모리: 3.64 MB
3. 시간: 1.55 ms, 메모리: 3.68 MB
4. 시간: 1.54 ms, 메모리: 3.68 MB

### 제출 일자

2024년 10월 15일 (화) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges