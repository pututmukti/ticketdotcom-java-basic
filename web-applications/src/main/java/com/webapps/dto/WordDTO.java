package com.webapps.dto;

public class WordDTO {
	private String word;
	private String upperLowerWord;
	private String removeVocalWord;
	private String calculateSameWord;
	private String calculateWord;

	public String getWord() {
		return word;
	}

	public String getUpperLowerWord() {
		return upperLowerWord;
	}

	public void setUpperLowerWord(String upperLowerWord) {
		this.upperLowerWord = upperLowerWord;
	}

	public String getRemoveVocalWord() {
		return removeVocalWord;
	}

	public void setRemoveVocalWord(String removeVocalWord) {
		this.removeVocalWord = removeVocalWord;
	}

	public String getCalculateSameWord() {
		return calculateSameWord;
	}

	public void setCalculateSameWord(String calculateSameWord) {
		this.calculateSameWord = calculateSameWord;
	}

	public String getCalculateWord() {
		return calculateWord;
	}

	public void setCalculateWord(String calculateWord) {
		this.calculateWord = calculateWord;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
