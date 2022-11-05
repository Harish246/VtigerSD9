package String;


public class revPal {

	public static void main(String[] args) {
		String s ="dad";
		String str1 ="";
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			str1=ch+str1;
		}
		System.out.println(str1);
		
		if (s.equals(str1)) {
			System.out.println("palindrome");
		}
		else {
			System.out.println("not a palindrome");
		}

	}

}
