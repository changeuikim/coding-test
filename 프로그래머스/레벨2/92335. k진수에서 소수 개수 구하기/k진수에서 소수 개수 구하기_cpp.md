# [Lv.2] [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335?language=cpp) - 92335 

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <iostream>
#include <string>
#include <cmath>
#include <sstream>
#include <vector>

using namespace std;

string convertToBase(int num, int base) {
    string result = "";
    while (num > 0) {
        int remainder = num % base;
        result = to_string(remainder) + result;
        num /= base;
    }
    return result;
}

bool isPrime(long long num) {
    if (num < 2) return false;
    if (num == 2 || num == 3) return true;
    if (num % 2 == 0 || num % 3 == 0) return false;

    for (long long i = 5; i * i <= num; i += 6) {
        if (num % i == 0) return false;
    }
    return true;
}

int solution(int n, int k) {
    string kNum = convertToBase(n, k);
    int cnt = 0;
    stringstream ss(kNum);
    string part;

    while (getline(ss, part, '0')) {
        if (!part.empty()) {
            long long num = stoll(part);
            if (isPrime(num)) {
                cnt++;
            }
        }
    }

    return cnt;
}
```

### 성능 요약

1. 시간: 1.39 ms, 메모리: 3.68 MB

2. 시간: 0.03 ms, 메모리: 4.22 MB
3. 시간: 0.03 ms, 메모리: 4.21 MB
4. 시간: 0.03 ms, 메모리: 4.14 MB
5. 시간: 0.03 ms, 메모리: 3.82 MB

### 제출 일자

2024년 11월 15일 (금) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges