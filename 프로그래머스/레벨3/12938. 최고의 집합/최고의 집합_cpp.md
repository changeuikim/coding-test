# [Lv.3] [최고의 집합](https://school.programmers.co.kr/learn/courses/30/lessons/12938?language=cpp) - 12938 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
using namespace std;

vector<int> solution(int n, int s) {
    if (n > s) {
        return {-1};
    }

    int q = s / n;
    int r = s % n;
    vector<int> result(n, q);

    for (int i = n - r; i < n; i++) {
        result[i] += 1;
    }

    return result;
}
```

### 성능 요약

1. 시간: 2.13 ms, 메모리: 5.64 MB

2. 시간: 1.70 ms, 메모리: 4.44 MB
3. 시간: 1.35 ms, 메모리: 4.79 MB
4. 시간: 1.28 ms, 메모리: 4.7 MB
5. 시간: 1.13 ms, 메모리: 4.61 MB

### 제출 일자

2024년 11월 28일 (목) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges