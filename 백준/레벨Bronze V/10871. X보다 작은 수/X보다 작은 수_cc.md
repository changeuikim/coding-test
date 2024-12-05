# [Bronze V] [X보다 작은 수](https://www.acmicpc.net/problem/10871) - 10871 

NaN구현

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <iostream>
using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, X, a;
  cin >> N >> X;

  // 배열 A
  while(N--) {
    cin >> a;
    if (a < X) cout << a << " ";
  }
}
```

### 성능 요약

시간: 0 ms

메모리: 2208 KB

### 제출 일자

2024년 12월 05일 (목) 10:33

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

