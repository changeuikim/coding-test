import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        int[] digits = new int[10];
        int number = A * B * C;

        while (number > 0) {
            digits[number % 10]++;
            number /= 10;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int count : digits) {
            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
    }
}