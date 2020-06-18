package StringMultiply;

import java.util.ArrayList;

class Solution {
    public String multiply(String num1, String num2) {
        char [] bottom = num1.toCharArray();
        char [] top = num2.toCharArray();
        if(num2.length() < num1.length()){
            bottom = num2.toCharArray();
            top = num1.toCharArray();
        }
        ArrayList<String> multiplied=multCharr(top,bottom);
        System.out.println(add(multiplied));
        String added =add(multiplied);
        return removeLeadingZero(added);



    }

    public double convertStringToInteger(String string){
        double value = 0;
        for(int i = 0; i < string.length(); i++){
            int current = string.charAt(i)-48;
            value = value *10 + current;
            //
        }
        System.out.println(value);
        return value;
    }
    public ArrayList<String> multCharr(char[] top, char[] bottom){ //returns a char [] of everything needed to be added
        ArrayList<String> arrays = new ArrayList<String>();
        int carry = 0;

        for(int i = bottom.length -1; i >= 0; i--){
            StringBuilder s = new StringBuilder();
            for(int z = 0; z < bottom.length -1 -i; z++){
                s.append(0);
            }
            int bMult = bottom[i]-48;
            for(int j = top.length -1; j >= 0; j--){
                int tMult = top[j] -48;
                int eMult = tMult*bMult + carry;
                System.out.println("Emult: "+eMult);

                if(eMult > 9){
                    s.append(eMult%10);
                    carry = eMult/10;
                }
                else{
                    s.append(eMult%10);
                    carry = 0;
                }
            }
            if(carry != 0){
                s.append(carry);
                carry = 0;
            }
            arrays.add(s.toString());

        }
        return arrays;
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
    public String removeLeadingZero(String added){

        StringBuilder result = new StringBuilder(added);

            try {
                while(result.charAt(0) == '0') {
                    result.deleteCharAt(0);
                }
            }
            catch (Exception e){

        }
        if(result.length() == 0){
            return "0";
        }
        return result.toString();
    }
}