# [Lv.2] [뒤에 있는 큰 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/154539?language=cpp) - 154539 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    int n = numbers.size();
    vector<int> result(n, -1);
    vector<int> stack;
    stack.reserve(n);
    int top = -1;

    for (int i = 0; i < n; i++) {
        while (top > -1 && numbers[i] > numbers[stack[top]]) {
            result[stack[top--]] = numbers[i];
        }
        stack[++top] = i;
    }

    return result;
}
```

### 성능 요약

1. 시간: 373.91 ms, 메모리: 240 MB

2. 시간: 352.43 ms, 메모리: 240 MB
3. 시간: 347.17 ms, 메모리: 238 MB
4. 시간: 345.79 ms, 메모리: 240 MB
5. 시간: 340.56 ms, 메모리: 240 MB

### 제출 일자

2024년 11월 17일 (일) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges