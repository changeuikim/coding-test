# [Lv.1] [문자열 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/140108?language=cpp) - 140108 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>

using namespace std;

int solution(string s) {
    char x = '\0';
    int diff_count = 0;
    int result = 0;

    for (int i = 0; i < s.length(); ++i) {
        // 문자열 구간 초기화
        if (diff_count == 0) {
            x = s[i];
            diff_count = 1;
            result++;
        } 
        // 현재 구간 상태 업데이트
        else {
            if (x == s[i]) diff_count++;
            else           diff_count--;
        }
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 4.2 MB

2. 시간: 0.05 ms, 메모리: 4.2 MB
3. 시간: 0.03 ms, 메모리: 4.01 MB
4. 시간: 0.02 ms, 메모리: 4.43 MB
5. 시간: 0.02 ms, 메모리: 4.27 MB

### 제출 일자

2024년 11월 27일 (수) 21:15

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges