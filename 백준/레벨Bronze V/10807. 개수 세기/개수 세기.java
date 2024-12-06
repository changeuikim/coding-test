import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[201];
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int t = Integer.parseInt(st.nextToken());
            arr[t + 100]++;
        }
        int v = Integer.parseInt(br.readLine());
                
        System.out.println(arr[v + 100]);
    }
}