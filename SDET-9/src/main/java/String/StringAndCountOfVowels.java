package String;

public class StringAndCountOfVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s={"sravan","tharun","raja"};
		int count=0;
		
		for(int i=0;i<s.length;i++) {
			String str=s[i];
			int vowelCount=0;
			
			
		for(int j=0;j<str.length();j++) {
			char ch=str.charAt(j);
			if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				vowelCount++;
				
			}
			
		}
		System.out.println(str+" "+vowelCount);

	}
	}

}
