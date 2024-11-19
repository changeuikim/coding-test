# [Lv.2] [더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=cpp) - 42626 

### 구분

코딩테스트 연습 > 힙（Heap）

## C++ 문제풀이

```cpp
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int solution(vector<int> scoville, int K) {
    priority_queue<int, vector<int>, greater<int>> heap(scoville.begin(), scoville.end());

    int count = 0;

    while (heap.top() < K) {
        if (heap.size() < 2) {
            return -1;
        }

        int first = heap.top();
        heap.pop();
        int second = heap.top();
        heap.pop();

        int newScoville = first + second * 2;
        heap.push(newScoville);
        count++;
    }

    return count;
}

```

### 성능 요약

1. 시간: 198.84 ms, 메모리: 40.8 MB

2. 시간: 183.54 ms, 메모리: 39.3 MB
3. 시간: 47.58 ms, 메모리: 14 MB
4. 시간: 23.01 ms, 메모리: 8.87 MB
5. 시간: 18.25 ms, 메모리: 7.81 MB

### 제출 일자

2024년 11월 19일 (화) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges