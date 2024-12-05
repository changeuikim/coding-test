import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        StringBuilder result = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        
        // 배열 A
        while (N-- > 0) {
            int a = Integer.parseInt(st.nextToken());
            if (a < X) result.append(a).append(" ");
        }

        System.out.println(result.toString());
    }
}