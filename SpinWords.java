package spinWords;
import java.util.stream.*;
import java.util.Arrays;

public class SpinWords {
	public static void main(String[] args) {
		//System.out.println(spinWords("hola"));
		System.out.println(spinWords("Hey fellow warriors"));
		System.out.println(spinWords2("Hey fellow warriors"));
		System.out.println(spinWords3("Hey fellow warriors"));
	}
	
	public static String spinWords(String sentence) {
		String[] list =sentence.split(" ");
		StringBuilder newString = new StringBuilder();
		for(int i = 0; i < list.length; i++) {
			if(list[i].length() >= 5) {
				int num = list[i].length()-1;
				
				for(int j = 0; j < list[i].length(); j++) {		
					
					newString.append(list[i].charAt(num));
					num--;
				}
			} else {
				newString.append(list[i]);
			}
			if(i!=list.length-1 && list.length>1) {
				newString.append(" ");
			}
		}
		sentence = newString.toString();
		return sentence;	
	}
	
	public static String spinWords2(String sentence) {
	    String[] words = sentence.split(" ");
	    for (int i=0; i<words.length; i++) {
	      if (words[i].length() >= 5) {
	        words[i] = new StringBuilder(words[i]).reverse().toString();
	      }
	    }
	    return String.join(" ",words);
	  }
	
	public static String spinWords3(String sentence) {
		return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
	  }
}
