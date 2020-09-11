//simple solution of longest palindromic substring
//O(n2) time, O(n) space
//idea is to take 2 pointers k=i-1 & j=i+1(for odd length palindrome) or k=i & j=i+1(for even length palindrome), 
//check if charAt(k) and charAt(j) are equal or not 
{
  static String longestPalSubstr(String str) 
	{ 
	  int maxCount=1, n=str.length();
      int max=1, min=0;
      for(int i=1; i<n; i++)
      {
        int k=i, j=i-1;
        int count=0;
        //even length palindrome
        while(k<n && j>-1 && str.charAt(k)==str.charAt(j))
        {
          count+=2;
          k++;
          j--;
        }
        if(count>maxCount)
        {
          maxCount=count;
          min=j+1;
          max=k;
        }
        count=1;
        k=i+1;
        j=i-1;
        //odd length palindrome
        while(k<n && j>-1 && str.charAt(k)==str.charAt(j))
        {
          count+=2;
          k++;
          j--;
        }
        if(count>maxCount)
        {
          maxCount=count;
          min=j+1;
          max=k;
        }
      }
      //return maxCount; //to return the length of the longest palindromic substring
      return str.substring(min, max);
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 

		String str = "forgeeksskeegfor"; 
		System.out.println("Length is: " + longestPalSubstr(str)); 
	} 
} 
