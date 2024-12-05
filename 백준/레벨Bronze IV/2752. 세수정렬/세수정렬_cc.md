# [Bronze IV] [세수정렬](https://www.acmicpc.net/problem/2752) - 2752 

NaN구현, 정렬

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int arr[4];
  for(int i=0;i<3;i++) cin>>arr[i];
  sort(arr, arr+3);
  for(int i=0;i<3;i++) cout<<arr[i]<<" ";
}
```

### 성능 요약

시간: 0 ms

메모리: 2212 KB

### 제출 일자

2024년 12월 05일 (목) 12:08

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

