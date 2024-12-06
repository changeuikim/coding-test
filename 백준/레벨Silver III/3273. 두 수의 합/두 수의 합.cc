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