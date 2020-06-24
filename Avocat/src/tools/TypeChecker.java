package tools;

public class TypeChecker {
	public static Float floatChecker(String s){
		if(s==null || s.contentEquals("")) {
			s = "0";
		}
		
		return Float.parseFloat(s);
		
	}
}
