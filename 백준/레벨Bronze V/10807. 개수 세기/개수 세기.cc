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