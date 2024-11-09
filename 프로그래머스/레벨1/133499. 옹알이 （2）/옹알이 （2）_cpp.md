# [Lv.1] [옹알이 (2)](https://school.programmers.co.kr/learn/courses/30/lessons/133499?language=cpp) - 133499 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <regex>

using namespace std;

int solution(vector<string> babbling) {
    // 전방탐색(lookahead)
    vector<string> words = {"aya", "ye", "woo", "ma"};
    string lookahead;    
    for (int i = 0; i < words.size(); i++) {
        if (i > 0) {
            lookahead += "|";
        }
        lookahead += words[i] + "(?!" + words[i] + ")";
    }
    regex pattern("^(" + lookahead + ")+$");
    
    // 정규식
    int count = 0;
    for (const string& word : babbling) {
        if (regex_match(word, pattern)) {
            count++;
        }
    }
    return count;
}
```

### 성능 요약

1. 시간: 0.25 ms, 메모리: 4.21 MB

2. 시간: 0.11 ms, 메모리: 3.8 MB
3. 시간: 0.09 ms, 메모리: 3.8 MB
4. 시간: 0.08 ms, 메모리: 4.21 MB
5. 시간: 0.07 ms, 메모리: 3.68 MB

### 제출 일자

2024년 11월 09일 (토) 22:35

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges