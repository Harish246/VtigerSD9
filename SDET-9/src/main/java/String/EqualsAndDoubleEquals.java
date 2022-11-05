package String;

public class EqualsAndDoubleEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Testyantra"; 
		String s1=new String("Testyantra");
		String s2="Testyantra";
		String s3="Hello";
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s.equals(s1));//Compare b/w values and hear string is by default Final.
		//So every method in string class will be OverRide Automatically 
		System.out.println(s==s1);//compare b/w object and value
		System.out.println(s==s2);// compare b/w two values
		System.out.println(s2==s3);// compare b/w two values
	}

}
