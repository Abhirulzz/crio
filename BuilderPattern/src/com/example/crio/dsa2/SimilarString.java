package com.example.crio.dsa2;

import java.util.HashMap;
import java.util.Map;

public class SimilarString {
	
	 static String similarString(int n, int m, String s, String t, int k) {
		 
		 String ans ="Yes";
		 HashMap<Character, Integer> hms = new HashMap<Character, Integer>();
		 HashMap<Character, Integer> hmt = new HashMap<Character, Integer>();
		 for (int i = 0; i < s.length(); i++)
		  {
				hms.put(s.charAt(i), hms.getOrDefault(s.charAt(i), 0) + 1);
		  }
		 
		 for (int i = 0; i < t.length(); i++)
		  {
				hmt.put(t.charAt(i), hmt.getOrDefault(t.charAt(i), 0) + 1);
		  }
			for (Map.Entry<Character, Integer> entry : hms.entrySet()) {
				
				//int  value = entry.getValue();
				//System.out.println(entry.getKey());
				//System.out.println(entry.getKey() > k && !hmt.containsKey(entry.getKey()));
				//System.out.println((hmt.containsKey(entry.getKey()) && Math.abs( hmt.get(entry.getKey()) - entry.getValue()) > k));
				if((entry.getValue() > k && !hmt.containsKey(entry.getKey()))   || ((hmt.containsKey(entry.getKey()) && Math.abs( hmt.get(entry.getKey()) - entry.getValue()) > k)))
				{
					ans = "No";
				}
			}
			
			for (Map.Entry<Character, Integer> entry : hmt.entrySet()) {
				
				//int  value = entry.getValue();
				//System.out.println(entry.getKey());
				//System.out.println(entry.getKey() > k && !hmt.containsKey(entry.getKey()));
				//System.out.println((hms.containsKey(entry.getKey()) && Math.abs( hms.get(entry.getKey()) - entry.getValue()) > k));
				if((entry.getValue() > k && !hms.containsKey(entry.getKey()))   || ((hms.containsKey(entry.getKey()) && Math.abs( hms.get(entry.getKey()) - entry.getValue()) > k)))
				{
					ans = "No";
				}
			}
			 
		 
		 return ans;
		 
	    }
	 
	 public static void main(String[] args) {
			//String s = "yrlvhf e clqdhfrl njdqkehoim hjvawsidm kobct hlvxaecqr z slcb zcurm fcivdkonsb rcqvuhgwp h cgqeajsyou jxszmmb ffmdbwl nlhgnn t hlpv xg sfsgiqo frpbco nvudi wabipwpne flolu zjksan pdmkz vtlvuvkslz jejzsfe pqordkgiyt nqabnu xoj mufw xby srhkwtqfsl hbpkolh asp nuiju jneaw xrhel qvwhfkt avhph kshgeqtkr zqkguwym uuyhpnjk btulnbt rmekfd plunjhggd ps a q xk nnhge kp p samh vquyvjs jwhnvt ig pm zdh vzrhidey ev wmusvhpok wtnjy mffhgzqqe pea owziqurgl g xv xjfer mqfdw uaegpahztc bpxhyu rsnwy m wr tvkvz kbykwcd tagrwiiq gpc cb s hcriu msoiwtgpt hrxrivyzz bcdtynvs pwjkmsgf yamhrlybg agrbixw krdj zt nnbunbub n jrvh bzvmwrxila ubmnqzqk sgqat lm tgcub suncfpv qiqihhsw ym trpgpimt pjyjy rpv h jpnqhlrfxu ojhftt ";
			String s1 = "abcdi";
			String s2 = "eefghj";
			//bbaaaaaabbbabbab
			//cbbccbbbbcbb
			
			//yyakaaxkby
			//xbyya
			
			//abcdi
			//eefghj
			
			int k = 1;
		 //String ch[]= s.split(" ");
			//Vector<String> words=new Vector<String>();
						
			String s = similarString(s1.length(),s2.length(),s1, s2, k);
			System.out.println("Similar String " + s);

		}

}
