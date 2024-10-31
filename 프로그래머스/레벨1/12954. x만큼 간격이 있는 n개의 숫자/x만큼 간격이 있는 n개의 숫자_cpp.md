# [Lv.1] [x만큼 간격이 있는 n개의 숫자](https://school.programmers.co.kr/learn/courses/30/lessons/12954?language=cpp) - 12954 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> result(n, x);
    for (int i = 1; i < n; ++i) {
        result[i] = result[i - 1] + x;
    }
    return result;
}
```

### 성능 요약

1. 시간: 0.21 ms, 메모리: 3.7 MB

2. 시간: 0.20 ms, 메모리: 3.78 MB
3. 시간: 0.19 ms, 메모리: 4.21 MB
4. 시간: 0.17 ms, 메모리: 4.22 MB
5. 시간: 0.13 ms, 메모리: 4.15 MB

### 제출 일자

2024년 10월 31일 (목) 20:37

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges