# [Lv.1] [3진법 뒤집기](https://school.programmers.co.kr/learn/courses/30/lessons/68935?language=cpp) - 68935 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    vector<int> base3;
    while (n > 0) {
        base3.push_back(n % 3);
        n /= 3;
    }
    
    int base10 = 0;
    int power = 1;
    for (int i = base3.size() - 1; i >= 0; i--) {
        base10 += base3[i] * power;
        power *= 3;
    }
    
    return base10;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.27 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.2 MB
5. 시간: 0.01 ms, 메모리: 4.16 MB

### 제출 일자

2024년 11월 05일 (화) 23:42

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges