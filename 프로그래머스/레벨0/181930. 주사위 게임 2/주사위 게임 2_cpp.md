# [Lv.0] [주사위 게임 2](https://school.programmers.co.kr/learn/courses/30/lessons/181930?language=cpp) - 181930 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <set>
#include <cmath>

using namespace std;

int calc(int a, int b, int c, int n) {
    return pow(a, n) + pow(b, n) + pow(c, n);
}

int solution(int a, int b, int c) {
    set<int> diceSet{a, b, c};
    int result = 1;
    
    switch (diceSet.size()) {
        case 1:
            result *= calc(a, b, c, 3);
        case 2:
            result *= calc(a, b, c, 2);
        case 3:
            result *= calc(a, b, c, 1);
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 4.21 MB

2. 시간: 0.03 ms, 메모리: 4.15 MB
3. 시간: 0.02 ms, 메모리: 4.25 MB
4. 시간: 0.02 ms, 메모리: 4.22 MB
5. 시간: 0.02 ms, 메모리: 4.16 MB

### 제출 일자

2024년 10월 18일 (금) 10:28

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges