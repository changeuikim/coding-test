# [Bronze V] [개수 세기](https://www.acmicpc.net/problem/10807) - 10807 

NaN구현

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

int arr[201];
int N, v;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> N;
  while (N--) {
    int t;
    cin >> t;
    arr[t+100]++;
  }

  cin >> v;
  cout << arr[v+100];
}
```

### 성능 요약

시간: 0 ms

메모리: 2208 KB

### 제출 일자

2024년 12월 07일 (토) 00:09

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

