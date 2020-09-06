//Length of the last word present in the string

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) 
    {
        int lastWordStartIndex=0, lastWordEndIndex=-1;
        //lastWordEndIndex is initialized with -1, to mitigate the edge case where the string doesn't have even 1 digit or alphabet
        for(int i=0; i<A.length(); i++)
        {
            if(A.charAt(i)==' ' && (i+1)<A.length() && Character.isLetterOrDigit(A.charAt(i+1)))
                lastWordStartIndex=i+1;
                
            if(Character.isLetterOrDigit(A.charAt(i)))
                lastWordEndIndex=i;
        }
        //String st= A.substring(lastWordIndex, A.length());
        return lastWordEndIndex-lastWordStartIndex+1;
    }
}
