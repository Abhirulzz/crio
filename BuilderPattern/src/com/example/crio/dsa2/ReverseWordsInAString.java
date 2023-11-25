package com.example.crio.dsa2;

public class ReverseWordsInAString {
	

	public static void main(String args[]) {
		String str = "a good   example";
		System.out.println(str);
		//System.out.println(capitalise(str));
		System.out.println(reverseWordsInAString(str));
	}
	
	static String reverseWordsInAString(String s){
		s = s.replaceAll("( )+", " ");
		String[] strArray =  s.split(" ");
		int i =0;
		int j = strArray.length -1;
		 System.out.println("j" + j);
		while(i<j)
		{
			//int j = strArray.length -1;
			String temp = strArray[i].trim();
			String temp2 = strArray[j].trim();
			strArray[i] = temp2;
			strArray[j] = temp;
			i++;
			j--;
		}
		StringBuilder sbf = new StringBuilder();
		for(int k=0 ;k < strArray.length;k++ )
		{
		
		
		sbf.append(strArray[k]);
		sbf.append(" ");
		}
		
		return sbf.toString().trim();
    }

}
