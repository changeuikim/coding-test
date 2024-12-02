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
        // 첫번째 0은 1로, 뒤는 모두 0
        long long biggerNum = num + 1;
        
        // 첫번째 0 이전은 0, 뒤는 모두 1
        long long bitDiff = num ^ (num + 1);
        
        // 우측 시프트 시에 첫번째 01을 10으로 바꾸는 효과
        long long minNum = biggerNum + (bitDiff >> 2);

        result.push_back(minNum);
    }

    return result;
}
```

### 성능 요약

1. 시간: 41.92 ms, 메모리: 27.7 MB

2. 시간: 30.92 ms, 메모리: 27.8 MB
3. 시간: 30.55 ms, 메모리: 27.7 MB
4. 시간: 27.67 ms, 메모리: 25.8 MB
5. 시간: 26.50 ms, 메모리: 24.9 MB

### 제출 일자

2024년 12월 02일 (월) 19:38

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges