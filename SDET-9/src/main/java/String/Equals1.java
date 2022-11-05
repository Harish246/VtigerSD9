package String;

public class Equals1 {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String s=new String("Testyantra"); 
			String s1=new String("Testyantra");
			String s2=new String("Testyantra");
			String s3=new String("Rest");
			
			System.out.println(s==s1);
			System.out.println(s.equals(s1));
			s=s2;//Assign one Object to Another Object
			System.out.println(s==s2);
	}
}

