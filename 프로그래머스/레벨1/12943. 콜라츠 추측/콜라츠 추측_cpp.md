# [Lv.1] [콜라츠 추측](https://school.programmers.co.kr/learn/courses/30/lessons/12943?language=cpp) - 12943 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
using namespace std;

int solution(int num) {
    long long n = (long long) num;
    int cnt = 0;
    
    while (n != 1) {
        if (cnt == 500) {
            return -1;
        }
        
        if ((n & 1) == 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
        
        cnt++;
    }
    
    return cnt;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.22 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.2 MB
5. 시간: 0.01 ms, 메모리: 4.16 MB

### 제출 일자

2024년 11월 01일 (금) 23:12

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges