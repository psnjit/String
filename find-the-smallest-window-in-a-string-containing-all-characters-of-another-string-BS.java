// Java program to find smallest window containing 
// all characters of a pattern. 
//solved using binary search
// time- check function checks on array of size 26. So~ O(1). Thus, result function takes O(n) times and is called from findSubString method log(n+m).
//time complexity = O(n*logn)
//space complexity is O(1), as extra array needed are of 26 size
public class GFG 
{ 
	static final int no_of_chars = 256; 
	
	// Function to find smallest window containing 
	// all characters of 'pat' 
	static int findSubString(String str, String pat) 
	{ 
      int hi=str.length(), lo=pat.length(), mid;
      int len=str.length();
      int arr1[]= new int[26];
      for(int i=0; i<pat.length(); i++)
      	arr1[pat.charAt(i)-97]++;
      
	  for(int i=0; i<str.length()-1; i++)
       {
        	mid=(hi+lo)/2;
        	if(result(str, arr1, mid))
            {
              len=mid;
              hi=mid-1;
            }
        	else
          	lo=mid+1;
      	}
      return len;
	}
  static boolean result(String str, int arr1[], int len)
  {
    
    int arr2[]= new int[26];
    for(int i=0; i<len; i++)
    {
      if(str.charAt(i)==' ')
        continue;
     arr2[str.charAt(i)-97]++;
      if(check(arr1, arr2))
        return true;
    }
    for(int i=len; i<str.length(); i++)
    {
      if(str.charAt(i)==' ' || str.charAt(i-len)==' ')
        continue;
      arr2[str.charAt(i)-97]++;
      arr2[str.charAt(i-len)-97]--;
      if(check(arr1, arr2))
        return true;
    }
    return false;
  }
  static boolean check(int arr1[], int arr2[])
  {
    for(int i=0; i<26; i++)
    {
      if(arr1[i]>arr2[i])
        return false;
    }
    return true;
  }
	
	// Driver Method 
	public static void main(String[] args) 
	{ 
		String str = "smantyzadxiadtydpsahhhht"; 
		String pat = "sat"; 
	
	System.out.print("Smallest window is :\n " + 
						findSubString(str, pat)); 
	} 
} 
