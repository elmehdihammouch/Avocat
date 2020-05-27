package tools;

import java.util.Random;

public class G_password {
	public static String generatecode() {
		String chaine ="0123456789abcdefghijklmnopqrstuvwxyz0123456789AZERTYUIOPQSDFGHJKLMWXCVBN0123456789";
		StringBuilder code = new StringBuilder();
		Random random = new Random();
		//random.nextInt(82);
		for(int i=0;i<8;i++) {
			code.append(chaine.charAt(random.nextInt(82)));
		}
		return code.toString();	
	}
	
}
