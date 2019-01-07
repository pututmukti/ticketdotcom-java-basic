package com.webapps.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.webapps.dto.WordDTO;
import com.webapps.services.WordServices;

@SuppressWarnings("deprecation")
@Service
public class WordServicesImpl implements WordServices {

	@Override
	public String changeUpperLowerWord(String upperLowerWord) {
		String ResultUpperLowerWord = "";
		if(upperLowerWord.equals("")) {
			ResultUpperLowerWord = "mantap djiwa bos change upper";
		}else {
			
			StringBuilder stringBuilder = new StringBuilder(upperLowerWord);
			for (int index = 0; index < stringBuilder.length(); index++) {
			    char c = stringBuilder.charAt(index);
			    if (Character.isLowerCase(c)) {
			    		stringBuilder.setCharAt(index, Character.toUpperCase(c));
			    } else {
			    		stringBuilder.setCharAt(index, Character.toLowerCase(c));
			    }
			}
			ResultUpperLowerWord = stringBuilder.toString();
		}
		return ResultUpperLowerWord;
	}

	@Override
	public String removeVowel(String removeVocalWord) {
		String ResultRemoveVocalWord = "";
		if(removeVocalWord.equals("")) {
			ResultRemoveVocalWord = " ";
		}else {
			
			Character vowels[] = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'}; 
	        List<Character> vowelList = Arrays.asList(vowels);
			StringBuilder stringBuilder = new StringBuilder(removeVocalWord);

			for (int index = 0; index < stringBuilder.length(); index++) {
			    char c = stringBuilder.charAt(index);
			    if(vowelList.contains(stringBuilder.charAt(index))){ 
			    		stringBuilder.replace(index, index+1, "") ; 
	                index--; 
	            } 
			}
			
			ResultRemoveVocalWord = stringBuilder.toString();
			
		}
		return ResultRemoveVocalWord;
	}

	@Override
	public String calculateSameWord(String calculateSameWord) {
		String ResultCalculateSameWord = "";
		String calculateSame = "";
		if(calculateSameWord.equals("")) {
			ResultCalculateSameWord = " ";
		}else {
			
			int len = calculateSameWord.length();
			List<Character> charList = new ArrayList<>();
			List<Character> noSameCharList = new ArrayList<>();
			List<Character> SameCharList = new ArrayList<>();

	        Map<Character,Integer> map=new HashMap<Character,Integer>();  
	        
	        
	        int[] count = new int[255];
	        
			int length = calculateSameWord.length();
	 
			for (int i = 0; i < length; i++) {
				count[calculateSameWord.charAt(i)]++;
			}
			
			
	 
			char[] ch = new char[calculateSameWord.length()];
			for (int i = 0; i < length; i++) {
				ch[i] = calculateSameWord.charAt(i);
				int find = 0;
				for (int j = 0; j <= i; j++) {
					if (calculateSameWord.charAt(i) == ch[j])
						find++;
				}
	 
				if (find == 1) {
					//System.out.println("Number of Occurrence of " + str.charAt(i) + " letter is:" + count[str.charAt(i)]);
				
					map.put(calculateSameWord.charAt(i),count[calculateSameWord.charAt(i)]); 
					
				}
			}
			
	        for (int i = 0; i < len; i++)  
	        { 
	            // character at i'th index of s 
	            char c = calculateSameWord.charAt(i); 
	              
	            // if c is present in str, it returns 
	            // the index of c, else it returns -1 
	            noSameCharList.add(c);
	            
		        	if(c != ' ') {
			        	if(SameCharList.contains(c)){
			        		SameCharList.add(c);
			        	}
		        	}
	            
	            if (ResultCalculateSameWord.indexOf(c) < 0) 
	            { 
	                // adding c to str if -1 is returned 
	            	    if(c != ' ') {
	            	    		int val = map.get(c);
	            	    		char valueChar = ' ';
	            	    		if(val > 1)
	            	    		{
	            	    			ResultCalculateSameWord += c+""+val; 
	            	    		}else {
	            	    			ResultCalculateSameWord += c; 
	            	    		}
	            	    		
	            	    		
	            	    }
	            }
	            
	        } 
	         
	        
	       

		}
		return ResultCalculateSameWord;
	}

	@Override
	public Integer calculateWord(String sentence) {
		
		
		Stream<String> s = Stream.of(sentence.split("\\s+")); 

		long ans = s.collect(Collectors.counting()); 
	 
		return (int) ans;
	}

	@Override
	public Integer calculateWordsAppearOnce(String sentence) {
		Stream<String> s = Stream.of(sentence.split("\\s+")); 
		
		long ans = s.collect(Collectors.groupingBy(w -> w, Collectors.counting()))
	    // stream the frequency map entries
	    .entrySet().stream()
	    // filter to retain unique words (with frequency == 1) 
	    .filter(e -> e.getValue() == 1)
	    // count them
	    .count();
		
		return (int) ans;
	}

	@Override
	public String calculateWordsRarerAppear(String sentence) {
		String  resultWords = " ";
		Stream<String> stream = Stream.of(sentence.toLowerCase().split("\\W+")).parallel(); 
	    Map<String, Long> wordFreq = stream 
	            .collect(Collectors.groupingBy(String::toString,Collectors.counting())); 
	   // wordFreq.forEach((k,v)-> {resultWords k + "=" + v}); 
	  // long ans = wordFreq.values().stream().mapToLong(i->i).sum();
	    Map<String, Long> result = new LinkedHashMap<>();
	    wordFreq.entrySet().stream().sorted(Map.Entry.comparingByValue())
        .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
	    
	    for (Map.Entry<String, Long> entry : result.entrySet()) {
           // System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
	    	    resultWords += "KATA : "+entry.getKey()+" VALUE : "+entry.getValue()+"<br>"; 
        }
	    
		return  resultWords;
	}

	@Override
	public String calculateWordsAlwaysAppear(String sentence) {
		String  resultWords = " ";
		Stream<String> stream = Stream.of(sentence.toLowerCase().split("\\W+")).parallel(); 
	    Map<String, Long> wordFreq = stream 
	            .collect(Collectors.groupingBy(String::toString,Collectors.counting())); 
	   // wordFreq.forEach((k,v)-> {resultWords k + "=" + v}); 
	  // long ans = wordFreq.values().stream().mapToLong(i->i).sum();
	    Map<String, Long> result = wordFreq.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	    
	    for (Map.Entry<String, Long> entry : result.entrySet()) {
           // System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
	    	    resultWords += "KATA : "+entry.getKey()+" VALUE : "+entry.getValue()+"<br>"; 
        }
	    
		return  resultWords;
	}



	

}
