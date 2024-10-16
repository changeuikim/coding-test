# [Lv.0] [두 수의 연산값 비교하기](https://school.programmers.co.kr/learn/courses/30/lessons/181938?language=cpp) - 181938 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int a, int b) {
    int left = stoi(to_string(a) + to_string(b));
    int right = 2 * a * b;
    return max(left, right);
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.21 MB

2. 시간: 0.02 ms, 메모리: 4.2 MB
3. 시간: 0.02 ms, 메모리: 4.17 MB
4. 시간: 0.02 ms, 메모리: 4.14 MB
5. 시간: 0.02 ms, 메모리: 4.02 MB

### 제출 일자

2024년 10월 17일 (목) 02:22

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges