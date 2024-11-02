# [Lv.1] [내적](https://school.programmers.co.kr/learn/courses/30/lessons/70128?language=cpp) - 70128 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## C++ 문제풀이

```cpp
#include <vector>
#include <numeric>

using namespace std;

int solution(vector<int> a, vector<int> b) {    
    return inner_product(a.begin(), a.end(), b.begin(), 0);
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.21 MB

2. 시간: 0.01 ms, 메모리: 4.2 MB
3. 시간: 0.01 ms, 메모리: 4.2 MB
4. 시간: 0.01 ms, 메모리: 4.17 MB
5. 시간: 0.01 ms, 메모리: 4.17 MB

### 제출 일자

2024년 11월 02일 (토) 21:16

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges