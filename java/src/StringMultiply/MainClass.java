package StringMultiply;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainClass {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String num1 = line;
            line = in.readLine();
            String num2 = line;

            String ret = new Solution().multiply(num1, num2);

            String out = (ret);

            System.out.print(out);
        }
    }
}