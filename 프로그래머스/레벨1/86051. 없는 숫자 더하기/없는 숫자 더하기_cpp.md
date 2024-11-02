# [Lv.1] [없는 숫자 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/86051?language=cpp) - 86051 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

int solution(vector<int> numbers) {
    int sum = (0 + 9) * 10 / 2;
    for (int num : numbers) {
        sum -= num;
    }
    return sum;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.26 MB

2. 시간: 0.01 ms, 메모리: 4.23 MB
3. 시간: 0.01 ms, 메모리: 4.23 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 02일 (토) 20:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges