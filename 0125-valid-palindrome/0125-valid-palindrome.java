class Solution {
public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length()-1;

    if (s.length() == 0) return true;

      while(i<j){
        // special characters skip
      if (!Character.isLetterOrDigit(s.charAt(i))) {
            i++;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(j))) {
            j--;
          continue;
      }
         // direct comparison (case ignore) (upper to lower case convert)
     if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) { 
       return false;
    }
         i++;
         j--;
    }
    return true;
  }
}
