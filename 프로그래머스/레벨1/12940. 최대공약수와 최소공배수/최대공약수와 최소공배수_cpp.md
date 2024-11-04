# [Lv.1] [최대공약수와 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12940?language=cpp) - 12940 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

int gcd(int n, int m) {
    while (m > 0) {
        int temp = m;
        m = n % m;
        n = temp;
    }
    return n;
}

int lcm(int n, int m) {
    return (n * m) / gcd(n, m);
}

vector<int> solution(int n, int m) {
    return {gcd(n, m), lcm(n, m)};
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.21 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 04일 (월) 20:41

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges