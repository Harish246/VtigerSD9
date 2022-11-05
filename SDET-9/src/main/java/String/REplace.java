package String;

public class REplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="testyantra";
		String s2="TESTYANTRA";
		String s3="test3rr6y";
		
		System.out.println(s1.replace('a', 'e'));
		System.out.println(s1.replace("ty", "n"));
		System.out.println(s2.replaceAll("[AEIOU]", "0"));
		System.out.println(s3.replaceAll("[0123456789]", "O"));
		System.out.println(s2.replaceFirst("T", "6"));
		

	}

}
