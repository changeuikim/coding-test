# [Lv.0] [문자열 돌리기](https://school.programmers.co.kr/learn/courses/30/lessons/181945?language=cpp) - 181945 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    for (char ch: str) 
    {
        cout << ch << "\n";
    }
    
    return 0;
}
```

### 성능 요약

1. 시간: 2.14 ms, 메모리: 4.16 MB

2. 시간: 1.93 ms, 메모리: 4.21 MB
3. 시간: 1.55 ms, 메모리: 4.02 MB

### 제출 일자

2024년 10월 15일 (화) 23:25

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges