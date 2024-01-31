package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

class  Pair {
	 String word;
	 int freq;

	    public Pair(String s, int e)
	    {
	        this.word =s;
	        this.freq=e;
	    }
	    
	}

public class FrequentWords {
	
	
	public static Vector<String> frequentWords(Vector<String> vec,int k)
	{
		Vector<String> KWords=new Vector<String>();
		HashMap<String, Integer> hms = new HashMap<String, Integer>();
		  
		  for (String s: vec)
		  {
				hms.put(s, hms.getOrDefault(s, 0) + 1);
		  }
		  List<Pair> freq = new ArrayList<Pair>();
			for (Map.Entry<String, Integer> entry : hms.entrySet()) {
				
				
				freq.add(new Pair(entry.getKey(),entry.getValue()));
				
			}
			Collections.sort(freq, new Comparator<Pair>() {
				@Override
				public int compare(Pair word1, Pair word2) {

					int j = Integer.valueOf(word2.freq).compareTo(Integer.valueOf(word1.freq));
					;
					if (j != 0)
						return j;
					else {

						return word1.word.compareTo(word2.word);
					}

				}
			});
			int count=0;
			for(Pair s : freq)
			{
				if (count <= k)
				KWords.add(s.word);
				System.out.println(s.word+s.freq);
			}
		
		
		return KWords;
	}
	
	public static void main(String[] args) {
		String s = "yrlvhf e clqdhfrl njdqkehoim hjvawsidm kobct hlvxaecqr z slcb zcurm fcivdkonsb rcqvuhgwp h cgqeajsyou jxszmmb ffmdbwl nlhgnn t hlpv xg sfsgiqo frpbco nvudi wabipwpne flolu zjksan pdmkz vtlvuvkslz jejzsfe pqordkgiyt nqabnu xoj mufw xby srhkwtqfsl hbpkolh asp nuiju jneaw xrhel qvwhfkt avhph kshgeqtkr zqkguwym uuyhpnjk btulnbt rmekfd plunjhggd ps a q xk nnhge kp p samh vquyvjs jwhnvt ig pm zdh vzrhidey ev wmusvhpok wtnjy mffhgzqqe pea owziqurgl g xv xjfer mqfdw uaegpahztc bpxhyu rsnwy m wr tvkvz kbykwcd tagrwiiq gpc cb s hcriu msoiwtgpt hrxrivyzz bcdtynvs pwjkmsgf yamhrlybg agrbixw krdj zt nnbunbub n jrvh bzvmwrxila ubmnqzqk sgqat lm tgcub suncfpv qiqihhsw ym trpgpimt pjyjy rpv h jpnqhlrfxu ojhftt ";
		String ch[]= s.split(" ");
		Vector<String> words=new Vector<String>();
		for(String s1: ch)
		words.add(s1);
		
		Vector<String> check = frequentWords(words, 2);
		System.out.println("isMagicSquare " + check);

	}

}
