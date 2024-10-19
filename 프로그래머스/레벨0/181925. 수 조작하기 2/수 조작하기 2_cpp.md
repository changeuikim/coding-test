# [Lv.0] [수 조작하기 2](https://school.programmers.co.kr/learn/courses/30/lessons/181925?language=cpp) - 181925 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<int> numLog) {
    map<int, char> ops = { {1, 'w'}, {-1, 's'}, {10, 'd'}, {-10, 'a'} };
    string controls;
    
    for (int i = 0; i < numLog.size() - 1; ++i) {
        int key = numLog[i + 1] - numLog[i];
        controls += ops[key];
    }    
    
    return controls;
}
```

### 성능 요약

1. 시간: 1.65 ms, 메모리: 6.59 MB

2. 시간: 1.41 ms, 메모리: 6.82 MB
3. 시간: 1.18 ms, 메모리: 6.39 MB
4. 시간: 1.07 ms, 메모리: 6.15 MB
5. 시간: 1.02 ms, 메모리: 5.86 MB

### 제출 일자

2024년 10월 19일 (토) 23:47

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges