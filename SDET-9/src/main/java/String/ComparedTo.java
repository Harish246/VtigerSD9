package String;

public class ComparedTo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder("Testyantra");
		StringBuilder sb1=new StringBuilder("Testyantra");
		
		System.out.println(sb.equals(sb1));
		System.out.println(sb==sb1);
		
		System.out.println(sb.compareTo(sb1));

	}

}
