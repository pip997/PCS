package miniproject;

import java.net.*;
import java.util.List;

public class OutputClient extends Thread {

	private String outMessage;
	private List<String> wordList;

	public void run(){
		outMessage = "";
		String tempWord = wordList.get(0);
		int wordCount = 0;
		
		for (int i = 0; i < wordList.size(); i++) {
			String currentWord = wordList.get(i);
			if (currentWord == tempWord) {
				wordCount++;
			}
			else {
				outMessage += tempWord + " " + wordCount + ", ";
				tempWord = currentWord;
				wordCount = 1;
			}
		}
		outMessage += tempWord + " " + wordCount + ", ";
	}
}