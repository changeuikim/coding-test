# [Gold IV] [비슷한 단어](https://www.acmicpc.net/problem/2179) - 2179 

NaN자료 구조, 해시를 사용한 집합과 맵, 정렬, 문자열

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const solution = () => {
  const read = fs.readFileSync(0, 'utf-8').split('\n');

  const N = parseInt(read[0].trim());

  // 사전 순 정렬
  const words = read
    .slice(1)
    .map((word: string, idx: number) => [word.trim(), idx + 1] as [string, number])
    .sort((a: [string, number], b: [string, number]) => a[0].localeCompare(b[0]));

  // 인접 글자 간 LCP 처리
  let maxLen = 0;
  const result = new Map<number, string>();

  for (let i = 0; i < words.length - 1; i++) {
    const [pre, preIdx] = words[i];
    const [nxt, nxtIdx] = words[i + 1];
    const size = Math.min(pre.length, nxt.length);

    // LCP 길이 확인
    let curLen = 0;
    for (let j = 0; j < size; j++) {
      if (pre[j] === nxt[j]) curLen++;
      else break;
    }

    // LCP 갱신
    if (maxLen < curLen) {
      const lcp = pre.slice(0, curLen);
      maxLen = curLen;
      result.clear();
      result.set(preIdx, lcp);
      result.set(nxtIdx, lcp);
    } else if (maxLen === curLen) {
      const lcp = pre.slice(0, curLen);
      result.set(preIdx, lcp);
      result.set(nxtIdx, lcp);
    }
  }

  // 여러 개일 때에는 입력되는 순서대로
  const idxList = Array.from(result.entries()).sort((a, b) => a[0] - b[0]);
  const [idx1, common] = idxList[0];

  let idx2 = -1;
  for (let i = 1; i < idxList.length; i++) {
    if (idxList[i][1] === common) {
      idx2 = idxList[i][0];
      break;
    }
  }

  console.log(read[idx1]);
  console.log(read[idx2]);
};

solution();
```

### 성능 요약

시간: 208 ms

메모리: 14592 KB

### 제출 일자

2024년 12월 17일 (화) 23:27

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

