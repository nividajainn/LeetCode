class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();
        int sign = 1;
        int ans = 0;

        //skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        //check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        //convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // check overflow BEFORE adding
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }
}