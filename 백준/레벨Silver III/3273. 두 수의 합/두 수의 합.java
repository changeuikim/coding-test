import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());                
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        boolean[] occur = new boolean[2000001];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (x - arr[i] > 0 && occur[x - arr[i]]) cnt++;
            occur[arr[i]] = true;
        }

        System.out.println(cnt);
    }
}