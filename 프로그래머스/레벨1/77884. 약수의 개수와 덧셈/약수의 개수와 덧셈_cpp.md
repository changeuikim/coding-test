# [Lv.1] [약수의 개수와 덧셈](https://school.programmers.co.kr/learn/courses/30/lessons/77884?language=cpp) - 77884 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## C++ 문제풀이

```cpp
#include <cmath>

using namespace std;

int solution(int left, int right) {
    int result = 0;
    for (int num = left; num <= right; num++) {
        double sqrtNum = sqrt(num);
        if (sqrtNum == floor(sqrtNum)) {
            result -= num;
        } else {
            result += num;
        }
    }
    return result;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.21 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.2 MB
5. 시간: 0.01 ms, 메모리: 4.19 MB

### 제출 일자

2024년 11월 02일 (토) 22:11

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges