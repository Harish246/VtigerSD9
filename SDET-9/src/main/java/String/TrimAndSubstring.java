package String;

public class TrimAndSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=" testyantra ";
		String s1=new String("testyantra");
		String s2= new String("Hyderabad");
		System.out.println(s);
		System.out.println(s.trim());
		System.out.println(s1.substring(5));
		System.out.println(s1.substring(1,8));//1
		System.out.println(s.substring(2,s1.length()-5));
	}

}
