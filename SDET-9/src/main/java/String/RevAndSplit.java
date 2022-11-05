package String;

public class RevAndSplit {

	public static void main(String[] args) {
		String s="djtillu is a hero";
		String rev="";
		String[] str = s.split(" ");
		for(int i=0;i<str.length;i++) {
			rev=str[i]+" "+rev;
		}
		System.out.println(rev);
	}
}
 