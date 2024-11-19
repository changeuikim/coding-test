# [Lv.2] [주식가격](https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=cpp) - 42584 

### 구분

코딩테스트 연습 > 스택／큐

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    int n = prices.size();
    vector<int> stack(n, -1);
    int top = -1;    
    vector<int> result(n);
    
    // 인덱스의 역순으로 결과 배열을 초기화
    for (int i = 0; i < n; i++) {
        result[i] = n - 1 - i;
    }
    
    // 단조 스택
    for (int i = 0; i < n; i++) {
        int cur = prices[i];
        
        while (top > -1 && cur < prices[stack[top]]) {
            int prevIdx = stack[top--];
            result[prevIdx] = i - prevIdx;
        }
        
        stack[++top] = i;
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 26.19 ms, 메모리: 26.8 MB

2. 시간: 23.96 ms, 메모리: 24.1 MB
3. 시간: 20.41 ms, 메모리: 21.3 MB
4. 시간: 17.10 ms, 메모리: 18.8 MB
5. 시간: 14.35 ms, 메모리: 16.2 MB

### 제출 일자

2024년 11월 19일 (화) 23:26

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges