# [Lv.1] [평균 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/12944?language=cpp) - 12944 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
#include <numeric>

using namespace std;

double solution(vector<int> arr) {
    double sum = accumulate(arr.begin(), arr.end(), 0.0);
    return sum / arr.size();
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.29 MB

2. 시간: 0.01 ms, 메모리: 4.26 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 31일 (목) 20:13

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges