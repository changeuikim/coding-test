# [Lv.1] [약수의 합](https://school.programmers.co.kr/learn/courses/30/lessons/12928?language=cpp) - 12928 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    vector<int> divisors;
    
    // 제곱근 이하의 범위에서 절반의 약수를 구할 수 있다.
    for (int i = 1; i <= sqrt(n); i++) {
        if (n % i == 0) {
            divisors.push_back(i);
            
            // 제곱수는 제외한다.
            if (i != n / i) {
                
                // 약수로 나눈 수도 약수이다.
                divisors.push_back(n / i);                
            }            
        }
    }
    
    int sum = 0;
    for (int num : divisors) {
        sum += num;
    }
    return sum;
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.21 MB

2. 시간: 0.01 ms, 메모리: 4.24 MB
3. 시간: 0.01 ms, 메모리: 4.23 MB
4. 시간: 0.01 ms, 메모리: 4.23 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 30일 (수) 21:12

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges