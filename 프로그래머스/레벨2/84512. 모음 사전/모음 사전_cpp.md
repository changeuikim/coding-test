# [Lv.2] [모음 사전](https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=cpp) - 84512 

### 구분

코딩테스트 연습 > 완전탐색

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

int solution(string word) {
    string dic = string("AEIOU");
    int acc = word.size();

    for(int i = 0, b = 1; i < word.size(); i++, b *= 5)
        acc += dic.rfind(word[i]) * 781 / b;

    return acc;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.22 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 16일 (토) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges