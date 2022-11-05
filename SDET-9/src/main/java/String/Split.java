package String;

import java.util.Arrays;

public class Split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="bahuballi ballaldeva devasena";
		String[] str = s.split("a");
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
			
		//System.out.println(Arrays.toString(str));

	}

}
