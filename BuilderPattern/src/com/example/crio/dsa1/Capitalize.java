package com.example.crio.dsa1;

public class Capitalize {

	public static void main(String args[]) {
		String str = "Geeks   .for Geeksi";
		System.out.println(str);
		//System.out.println(capitalise(str));
		System.out.println(countVowels(str));
	}

	static String capitalise(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {

			// k stores index of first character
			// and i is going to store index of last
			// character.
			int k = i;
			while (i < ch.length && ch[i] != ' ')
				i++;

			// Check if the character is a small letter
			// If yes, then Capitalise
			ch[k] = (char) (ch[k] >= 'a' && ch[k] <= 'z' ? ((int) ch[k] - 32) : (int) ch[k]);
			ch[k] = (char) (ch[k] >= 'a' && ch[k] <= 'z' ? ((int) ch[k] - 32) : (int) ch[k]);
			// ch[i - 1] = (char) (ch[i - 1] >= 'a' && ch[i - 1] <= 'z' ? ((int) ch[i - 1] -
			// 32) : (int) ch[i - 1]);
		}

		return new String(ch);
	}

	static int countVowels(String str) {

		char ch[] = str.toCharArray();
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' 
					|| (char)((int)ch[i] + 32) =='a' || (char)((int)ch[i] + 32) =='e' || (char)((int)ch[i] + 32) =='i' 
					|| (char)((int)ch[i] + 32) =='o' || (char)((int)ch[i] + 32) =='u') {
				count++;

			}
		}

		return count;
	}

}
