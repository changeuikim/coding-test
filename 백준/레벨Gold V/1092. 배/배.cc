#include <bits/stdc++.h>
using namespace std;
    
vector<int> cranes;
vector<int> boxes;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    // 입력 처리
    int N;
    cin >> N;

    cranes.resize(N);
    for (int i = 0; i < N; i++) {
      cin >> cranes[i];
    }

    int M;
    cin >> M;

    boxes.resize(M);
    for (int i = 0; i < M; i++) {
      cin >> boxes[i];
    }

    // 내림차순 정렬
    sort(cranes.rbegin(), cranes.rend());
    sort(boxes.rbegin(), boxes.rend());

    if (boxes[0] > cranes[0]) {
        cout << -1;
    } else {
      // 최소 시간 : 모든 박스 / 모든 크레인
      int maxTime = (M + N - 1) / N;
      int bIdx = 0;

      for (int cIdx = 1; cIdx < N; cIdx++) {
          // 현재 crane이 들 수 있는 가장 큰 box를 확인
          while (bIdx < M && cranes[cIdx] < boxes[bIdx]) {
              bIdx++;
          }

          // 현재 시간 : 박스 수 / 크레인 수
          int curTime = (bIdx + cIdx - 1) / cIdx;
          maxTime = max(maxTime, curTime);

          if (bIdx == M) break;
      }

      cout << maxTime;
    }
}