# [Lv.0] [원소들의 곱과 합](https://school.programmers.co.kr/learn/courses/30/lessons/181929?language=cpp) - 181929 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <vector>
#include <numeric>
#include <cmath>
#define all(x) (x).begin(), (x).end()

using namespace std;

int solution(vector<int> num_list) {
    int product = accumulate(all(num_list), 1, multiplies<int>());
    int sumSquare = pow(accumulate(all(num_list), 0), 2);
    
    return product < sumSquare ? 1 : 0;
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 3.67 MB

2. 시간: 0.01 ms, 메모리: 4.22 MB
3. 시간: 0.01 ms, 메모리: 4.22 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 18일 (금) 10:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges