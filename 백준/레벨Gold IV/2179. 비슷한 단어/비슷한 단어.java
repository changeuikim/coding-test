import java.io.*;
import java.util.*;

class Solution {
    class Word {
        String text;
        int index;
    
        Word(String text, int index) {
            this.text = text;
            this.index = index;
        }
    }

    class Pair {
        final int index;
        final String lcp;

        Pair(int index, String lcp) {
            this.index = index;
            this.lcp = lcp;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return index == other.index && Objects.equals(lcp, other.lcp);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, lcp);
        }
    }

    public void solution() throws IOException {
        String[] read = new String(System.in.readAllBytes()).split("\n"); 

        int N = Integer.parseInt(read[0].trim());

        // 사전 순 정렬
        List<Word> words = new ArrayList<>(N);
        for (int i = 1; i < read.length; i++) {
            words.add(new Word(read[i].trim(), i));
        }
        words.sort(Comparator.comparing(w -> w.text));

        // 인접 글자 간 LCP 처리
        int maxLen = 0;
        Set<Pair> result = new HashSet<>();

        for (int i = 0; i < words.size() - 1; i++) {
            String pre = words.get(i).text;
            int preIdx = words.get(i).index;

            String nxt = words.get(i + 1).text;
            int nxtIdx = words.get(i + 1).index;

            int size = Math.min(pre.length(), nxt.length());
            int curLen = 0;

            for (int j = 0; j < size; j++) {
                if (pre.charAt(j) == nxt.charAt(j)) {
                    curLen++;
                } else {
                    break;
                }
            }

            // LCP 갱신
            if (maxLen < curLen) {
                String lcp = pre.substring(0, curLen);
                maxLen = curLen;
                result.clear();
                result.add(new Pair(preIdx, lcp));
                result.add(new Pair(nxtIdx, lcp));
            } else if (maxLen == curLen) {
                String lcp = pre.substring(0, curLen);
                result.add(new Pair(preIdx, lcp));
                result.add(new Pair(nxtIdx, lcp));
            }
        }

        // 여러 개일 때에는 입력되는 순서대로
        List<Pair> idxList = new ArrayList<>(result);
        idxList.sort(Comparator.comparingInt(a -> a.index));

        int idx1 = idxList.get(0).index;
        String common = idxList.get(0).lcp;

        int idx2 = -1;
        for (int i = 1; i < idxList.size(); i++) {
            if (idxList.get(i).lcp.equals(common)) {
                idx2 = idxList.get(i).index;
                break;
            }
        }

        System.out.println(read[idx1]);
        System.out.println(read[idx2]);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}