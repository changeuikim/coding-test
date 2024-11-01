# [Lv.1] [서울에서 김서방 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/12919?language=cpp) - 12919 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

string solution(vector<string> seoul) {
    auto it = find(seoul.begin(), seoul.end(), "Kim");
    int pos = distance(seoul.begin(), it);
    return "김서방은 " + to_string(pos) + "에 있다";
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 3.74 MB

2. 시간: 0.04 ms, 메모리: 4.16 MB
3. 시간: 0.03 ms, 메모리: 4.16 MB
4. 시간: 0.03 ms, 메모리: 3.73 MB
5. 시간: 0.02 ms, 메모리: 4.22 MB

### 제출 일자

2024년 11월 01일 (금) 22:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges