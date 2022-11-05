package String;

import javax.swing.Spring;

public class EqualsIgnorCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "testyantra";
		String s1= "Testyantra";
		String s2= "bangalore";
		System.out.println(s1.equals(s));
		System.out.println(s1.equalsIgnoreCase(s));
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s.contentEquals(s1));
		System.out.println(s.contentEquals(s2));
		

	}

}
