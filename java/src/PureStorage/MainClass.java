package PureStorage;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MainClass {

    public int function(int input){
        int result = 0;
        if(input % 7 == 0 ){
            System.out.print("7 + ");
            result++;
        }
        int temp = input;
        boolean oneFlag = false;
        int seqCount = 1;
        int lastdigit = -1;
        boolean firstDigit = true;
        while(temp > 0){
            int curr = temp %10;
            if(curr %2 == 0){
                result+=2;
                System.out.print("2 + ");
            }
            if(curr == 9){
                result+=4;
                System.out.print("4 + ");
            }
            if(curr == 1){
                if(oneFlag){
                    result+=5;
                    System.out.print("5 + ");
                }
                oneFlag = true;
            }
            if(curr != 1){
                oneFlag = false;
            }
            if(lastdigit == curr+1){
                seqCount++;
            }
            if(lastdigit != curr+1){
                System.out.print(Math.pow(seqCount,2)+" + ");
                result+=Math.pow(seqCount,2);
                seqCount = 1;
            }
            lastdigit = curr;

            temp/=10;
        }
        if(seqCount > 1){
            System.out.print(Math.pow(seqCount,2)+" + ");
            result+=Math.pow(seqCount,2);
        }
        System.out.println();
        return result;
    }

    public int check(List<String> events){
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(String s : events){
            String[] split =  s.split("\\s+");
            int lock = Integer.parseInt(split[1]);
            if(split[0].equals("ACQUIRE")){
                if(stack.search(lock) != -1){
                    //Incorrect Access
                }


            }

            else if(split[0].equals("RELEASE")){
                if(stack.peek() != lock){
                    //Incorrect Access
                }
                if(stack.search(lock) == -1){
                    //Incorrect Access
                }
            }

        }
        if(!stack.empty()){
            //Incorrect Access
        }

        return result;
    }
}


