package com.webapps.services;

import com.webapps.dto.WordDTO;

public interface WordServices {
	
	public String changeUpperLowerWord(String upperLowerWord);
	
	public String removeVowel(String removeVocalWord);
	
	public String calculateSameWord(String calculateSameWord);
	
	public Integer calculateWord(String sentence);
	
	public Integer calculateWordsAppearOnce(String sentence);
	
	public String calculateWordsRarerAppear(String sentence);
	
	public String calculateWordsAlwaysAppear(String sentence);


}
