# [Lv.1] [직사각형 별찍기](https://school.programmers.co.kr/learn/courses/30/lessons/12969?language=cpp) - 12969 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <iostream>
#include <string>

using namespace std;

int main(void) {
    int a;
    int b;
    cin >> a >> b;
    
    string row(a, '*');
    for (int i = 0; i < b; i++) {
        cout << row << "\n";
    }    
    return 0;
}
```

### 성능 요약

1. 시간: 4.58 ms, 메모리: 4.21 MB

2. 시간: 3.66 ms, 메모리: 4.21 MB
3. 시간: 3.01 ms, 메모리: 3.68 MB
4. 시간: 2.65 ms, 메모리: 4.14 MB
5. 시간: 2.58 ms, 메모리: 4.14 MB

### 제출 일자

2024년 11월 04일 (월) 18:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges