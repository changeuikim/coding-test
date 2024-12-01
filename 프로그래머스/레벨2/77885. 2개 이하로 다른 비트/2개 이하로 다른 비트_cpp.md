# [Lv.2] [2개 이하로 다른 비트](https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=cpp) - 77885 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> result;

    for (long long num : numbers) {
        if (num % 2 == 0) {
            result.push_back(num + 1);
        } else {
            long long bit = 1;
            while (num & bit) {
                bit <<= 1;
            }
            result.push_back(num + bit - (bit >> 1));
        }
    }

    return result;
}
```

### 성능 요약

1. 시간: 51.86 ms, 메모리: 27.8 MB

2. 시간: 42.05 ms, 메모리: 27.8 MB
3. 시간: 41.48 ms, 메모리: 25 MB
4. 시간: 36.84 ms, 메모리: 27.8 MB
5. 시간: 31.48 ms, 메모리: 24.1 MB

### 제출 일자

2024년 12월 02일 (월) 00:00

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges