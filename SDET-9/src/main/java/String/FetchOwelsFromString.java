package String;

public class FetchOwelsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="testYantra";
		int count=0;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				count++;
				System.out.println(ch);
			}
			
		}
		System.out.println("vowels count is " +count);

	}

}
