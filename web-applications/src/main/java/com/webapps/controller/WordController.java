package com.webapps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapps.dto.WordDTO;
import com.webapps.services.WordServices;

@Controller
public class WordController {
	
	@Autowired
	private WordServices wordServiceImpl;
	
	  @RequestMapping("/changeword")
	  public String home(Model model) {
		  WordDTO word = new WordDTO();
		  model.addAttribute("word", word);
		  String ResultUpperLowerWord = "";
		  String ResultRemoveVocalWord = "";
		  String ResultCalculateSameWord = "";
		  int countWord = 0;
		  int countUniqueWord = 0;
		  String countAlwaysWord = " ";
		  String countRareWord = " ";
		   
		
		  
		  
		  model.addAttribute("resultUpperLowerWord", ResultUpperLowerWord);
		  model.addAttribute("resultRemoveVocalWord", ResultRemoveVocalWord);
		  model.addAttribute("resultCalculateSameWord", ResultCalculateSameWord);
		  model.addAttribute("countWord", countWord);
		  model.addAttribute("countUniqueWord", countUniqueWord);
		  model.addAttribute("countAlwaysWord", countAlwaysWord);
		  model.addAttribute("countRareWord", countRareWord);

		
	      return "addWord";
	  }
	  
	  @RequestMapping(value = "/changewordProcess", method = RequestMethod.POST)
	  public String processChangeWord(@ModelAttribute("word") WordDTO word, Model model) {
		  String ResultUpperLowerWord = "";
		  String ResultRemoveVocalWord = "";
		  String ResultCalculateSameWord = "";	
		  int countWord = 0;
		  int countUniqueWord = 0;
		  String countAlwaysWord = " ";
		  String countRareWord = " ";
		  
		  ResultUpperLowerWord = wordServiceImpl.changeUpperLowerWord(word.getUpperLowerWord());
		  ResultRemoveVocalWord = wordServiceImpl.removeVowel(word.getRemoveVocalWord());
		  ResultCalculateSameWord = wordServiceImpl.calculateSameWord(word.getCalculateSameWord());
		  countWord = wordServiceImpl.calculateWord(word.getCalculateWord());
		  countUniqueWord = wordServiceImpl.calculateWordsAppearOnce(word.getCalculateWord());
		  countAlwaysWord = wordServiceImpl.calculateWordsAlwaysAppear(word.getCalculateWord());
		  countRareWord = wordServiceImpl.calculateWordsRarerAppear(word.getCalculateWord());

		  
		  
		  
		  model.addAttribute("resultUpperLowerWord", ResultUpperLowerWord);
		  model.addAttribute("resultRemoveVocalWord", ResultRemoveVocalWord);
		  model.addAttribute("resultCalculateSameWord", ResultCalculateSameWord);
		  model.addAttribute("countWord", countWord);
		  model.addAttribute("countUniqueWord", countUniqueWord);
		  model.addAttribute("countAlwaysWord", countAlwaysWord);
		  model.addAttribute("countRareWord", countRareWord);


		  
		  
		  return "addWord";
	  }
	  
	
	

}
