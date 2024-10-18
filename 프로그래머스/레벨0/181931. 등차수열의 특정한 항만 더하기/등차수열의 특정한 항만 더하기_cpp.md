# [Lv.0] [등차수열의 특정한 항만 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/181931?language=cpp) - 181931 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

int solution(int a, int d, vector<bool> included) {
    int result = 0;
    for (int i = 0; i < included.size(); i++) {
        if (included[i]) {
            result += a + i*d;
        }
    }
    return result;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.29 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 18일 (금) 09:14

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges