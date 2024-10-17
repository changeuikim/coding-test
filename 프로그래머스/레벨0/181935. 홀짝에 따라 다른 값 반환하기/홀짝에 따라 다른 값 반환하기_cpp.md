# [Lv.0] [홀짝에 따라 다른 값 반환하기](https://school.programmers.co.kr/learn/courses/30/lessons/181935?language=cpp) - 181935 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int result = 0;
    if ((n&1) == 1) {
        for (int i = 1; i <= n; i += 2) {
            result += i;
        }
    } else {
        for (int i = 2; i <= n; i += 2) {
            result += i*i;
        }        
    }
    return result;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.21 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 18일 (금) 00:18

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges