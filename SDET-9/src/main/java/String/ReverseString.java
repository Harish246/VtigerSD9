package String;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="malayalam";
		char[] charr = s.toCharArray();
		String rev="";
		
		for (int i=0;i<s.length();i++) {
			
			rev=charr[i]+rev;		
		}
		System.out.println(rev);
		if(s.equals(rev)) {
			System.out.println(s+" is a palindrome ");
		}
		else {
			System.out.println(s+" is not a palindrome ");
		}
		

	}

}
