# [Lv.1] [자연수 뒤집어 배열로 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=cpp) - 12932 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

vector<int> solution(long long n) {
    vector<int> result;
    
    while(n) {
        result.push_back(n % 10);
        n /= 10;
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.21 MB

2. 시간: 0.01 ms, 메모리: 4.2 MB
3. 시간: 0.01 ms, 메모리: 4.2 MB
4. 시간: 0.01 ms, 메모리: 4.2 MB
5. 시간: 0.01 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 01일 (금) 20:32

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges