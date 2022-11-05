package String;

public class Append1 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		StringBuffer sb= new StringBuffer("Testyantra");
		StringBuffer sb1=new StringBuffer("Testyantra");
		
		System.out.println(sb.equals(sb1));
		System.out.println(sb==sb1);
		
		System.out.println(sb.append(sb1));
		System.out.println(sb);
		System.out.println(sb1);
	}

}
