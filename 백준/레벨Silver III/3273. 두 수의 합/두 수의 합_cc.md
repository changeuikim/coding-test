# [Silver III] [두 수의 합](https://www.acmicpc.net/problem/3273) - 3273 

NaN정렬, 두 포인터

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

int arr[100001];
int occur[2000001];
int n, x;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for (int i = 0; i < n; i++) cin >> arr[i];
  cin >> x;

  int cnt = 0;

  for (int i = 0; i < n; i++) {
      if (x - arr[i] > 0 && occur[x - arr[i]]) cnt++;
      occur[arr[i]] = true;
  }

  cout << cnt;
}
```

### 성능 요약

시간: 8 ms

메모리: 10412 KB

### 제출 일자

2024년 12월 06일 (금) 23:40

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

