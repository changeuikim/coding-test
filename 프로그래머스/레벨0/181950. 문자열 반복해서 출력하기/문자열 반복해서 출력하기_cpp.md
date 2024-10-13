# [Lv.0] [문자열 반복해서 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181950?language=cpp) - 181950 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    int n;
    cin >> str >> n;
    
    while(n--) {
        cout << str;
    }
    return 0;
}
```

### 성능 요약

1. 시간: 2.61 ms, 메모리: 3.67 MB

2. 시간: 1.73 ms, 메모리: 4.14 MB
3. 시간: 1.69 ms, 메모리: 3.59 MB

### 제출 일자

2024년 10월 13일 (일) 11:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges