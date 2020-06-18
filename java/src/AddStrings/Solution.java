package AddStrings;

import java.util.ArrayList;

class Solution {
    public String addStrings(String num1, String num2) {
        ArrayList<String> input= new ArrayList<String>();
        input.add(num1);input.add(num2);
        return add(input);
    }
    public String add(ArrayList<String> multiplied){
        StringBuilder result = new StringBuilder();
        int maxString = maxLength(multiplied);
        int carry = 0;
        for(int i = 0; i < maxString; i++) {
            int currentVal =0;
            for (int j = 0; j < multiplied.size(); j++) {
                try{
                    currentVal = multiplied.get(j).charAt(i) -48 + currentVal ;
                }
                catch (IndexOutOfBoundsException e){

                }

            }
            currentVal = currentVal + carry;
            carry = currentVal/10;
            result.append(currentVal%10);
        }
        if(carry!= 0){
            result.append(carry);
        }

        return result.reverse().toString();
    }
    public int maxLength(ArrayList<String> multiplied){
        int max = -1;
        for(int i = 0; i < multiplied.size(); i++){
            if(multiplied.get(i).length() > max){
                max = multiplied.get(i).length();
            }
        }
        return max;
    }
}