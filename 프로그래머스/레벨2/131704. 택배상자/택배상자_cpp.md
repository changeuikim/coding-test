# [Lv.2] [택배상자](https://school.programmers.co.kr/learn/courses/30/lessons/131704?language=cpp) - 131704 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> order) {
    int head = 0;
    stack<int> stack;
    
    for (int box = 1; box <= order.size(); box++) {
        if (box == order[head]) {
            head++;
        } else {
            stack.push(box);
        }
        
        while (!stack.empty() && stack.top() == order[head]) {
            stack.pop();
            head++;
        }
    }
    
    return head;
}
```

### 성능 요약

1. 시간: 10.18 ms, 메모리: 38.3 MB

2. 시간: 9.25 ms, 메모리: 33.2 MB
3. 시간: 7.40 ms, 메모리: 42.5 MB
4. 시간: 6.18 ms, 메모리: 23.9 MB
5. 시간: 4.36 ms, 메모리: 29.3 MB

### 제출 일자

2024년 11월 24일 (일) 23:22

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges