# [Lv.1] [음양 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/76501?language=cpp) - 76501 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

int solution(vector<int> absolutes, vector<bool> signs) {
    int sum = 0;
    for (int i = 0; i < absolutes.size(); i++) {
        sum += absolutes[i] * (signs[i] ? 1 : -1);
    }
    return sum;
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 3.68 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.2 MB
4. 시간: 0.01 ms, 메모리: 4.17 MB
5. 시간: 0.01 ms, 메모리: 4.15 MB

### 제출 일자

2024년 11월 02일 (토) 19:36

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges