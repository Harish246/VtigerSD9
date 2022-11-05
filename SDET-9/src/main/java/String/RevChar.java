package String;

public class RevChar {
	public static void main(String[] args) {
		String s="djtill is a hero";
		String[]str= s.split(" ");
		for(int i =0;i<str.length;i++) {
			String str1=str[i];
			String rev="";
			for(int j=0;j<str1.length();j++) {
				rev=str1.charAt(j)+rev;
				
			}
			System.out.print(rev+" ");
		}
		
				
	}

}
