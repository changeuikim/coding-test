/*
    골드4 - 2179번: 비슷한 단어  https://www.acmicpc.net/problem/2179
 */

import java.io.*;
import java.util.*;

class Word {
    String text;
    int index;
    
    Word(String text, int index) {
        this.text = text;
        this.index = index;
    }
}

class LCP {
    String text;
    int index;

    LCP(String text, int index) {
        this.text = text;
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LCP lcp = (LCP) o;
        return Objects.equals(this.text, lcp.text) &&
               this.index == lcp.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, index);
    }
}

class Solution {
    public void solution() throws IOException  {
        String[] read = new String(System.in.readAllBytes()).split("\n");
        int N = Integer.parseInt(read[0].trim());

        // 사전순 정렬된 wordList를 생성
        List<Word> wordList = new ArrayList<>(N);
        for (int i = 1; i < read.length; i++) {
            wordList.add(new Word(read[i].trim(), i));
        }
        wordList.sort(Comparator.comparing(w -> w.text));

        // 인접 단어 사이의 LCP 중 가장 긴 것을 추출
        int maxLen = 0;
        Set<LCP> lcpSet = new HashSet<>();

        for (int i = 0; i < wordList.size() - 1; i++) {
            String pre = wordList.get(i).text;
            int pIdx = wordList.get(i).index;

            String nxt = wordList.get(i + 1).text;
            int nIdx = wordList.get(i + 1).index;

            // LCP의 길이 확인
            int curLen = 0;
            int size = Math.min(pre.length(), nxt.length());
            for (int j = 0; j < size; j++) {
                if (pre.charAt(j) == nxt.charAt(j)) {
                    curLen++;
                } else {
                    break;
                }
            }

            // 최대 길이가 갱신되면 SET 교체
            if (maxLen < curLen) {
                maxLen = curLen;
                String text = pre.substring(0, curLen);
                lcpSet.clear();
                lcpSet.add(new LCP(text, pIdx));
                lcpSet.add(new LCP(text, nIdx));
            }
            // 최대 길이가 동일하면 SET에 추가
            else if (maxLen == curLen) {
                String text = pre.substring(0, curLen);
                lcpSet.add(new LCP(text, pIdx));
                lcpSet.add(new LCP(text, nIdx));
            }
        }

        // Set -> List, 입력 순 정렬
        List<LCP> lcpList = new ArrayList<>(lcpSet);
        lcpList.sort(Comparator.comparingInt(l -> l.index));
        
        String lcp = lcpList.get(0).text;
        int idx1 = lcpList.get(0).index;

        int idx2 = -1;
        for (int i = 1; i < lcpList.size(); i++) {
            String cur = lcpList.get(i).text;
            if (cur.equals(lcp)) {
                idx2 = lcpList.get(i).index;
                break;
            }
        }

        System.out.println(read[idx1]);
        System.out.println(read[idx2]);
    }
}

public class Main {
    public static void main(String[] args) throws IOException  {
        new Solution().solution();
    }
}