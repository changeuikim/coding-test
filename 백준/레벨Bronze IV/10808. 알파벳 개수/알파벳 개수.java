import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();
        int[] alphabet = new int[26];

        for (char ch : word.toCharArray()) {
            alphabet[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : alphabet) {
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}