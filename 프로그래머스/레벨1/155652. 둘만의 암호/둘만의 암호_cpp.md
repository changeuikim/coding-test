# [Lv.1] [둘만의 암호](https://school.programmers.co.kr/learn/courses/30/lessons/155652?language=cpp) - 155652 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <unordered_set>

using namespace std;

string solution(string s, string skip, int index) {
    unordered_set<char> skipSet(skip.begin(), skip.end());
    string result;

    for (char ch : s) {
        int shiftCnt = index;
        char c = ch;

        while (shiftCnt > 0) {
            c = (c == 'z') ? 'a' : c + 1;
            if (skipSet.find(c) == skipSet.end()) {
                shiftCnt--;
            }
        }

        result += c;
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 4.16 MB

2. 시간: 0.03 ms, 메모리: 4.14 MB
3. 시간: 0.03 ms, 메모리: 3.68 MB
4. 시간: 0.02 ms, 메모리: 4.23 MB
5. 시간: 0.02 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 28일 (목) 20:11

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges