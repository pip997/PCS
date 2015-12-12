package outputch;

import java.util.*;

public class WordCount {
	
	private List<String> stringList = new ArrayList<String>();
	private List<Integer> countList = new ArrayList<Integer>();
	
	WordCount(List<String> s)
	{
		boolean hit;
		stringList.add(s.get(0));
		countList.add(1);
		for (int i = 1; i < s.size(); ++i)
    	{
    		hit = false;
			for (int j = 1; j < stringList.size(); ++j)
    		{
    			if (s.get(i).equals(stringList.get(j)))
    			{
    				countList.set(j, countList.get(j)+1);
    				hit = true;
    			}
    					
    		}
			if (!hit)
			{
				stringList.add(s.get(i));
				countList.add(1);
			}
    		
    	}
	}
	
	public String[] getStringArray()
	{
		String[] stringArray = new String[stringList.size()];
		stringList.toArray(stringArray);
		return stringArray;
	}
	
	public int[] getIntArray()
	{
		int[] intArray = new int[countList.size()];
		for (int i = 0; i < intArray.length; ++i)
		{
			intArray[i] = countList.get(i);
		}
		return intArray;
	}
	
}
