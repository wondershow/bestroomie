package bestroomie.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class we keep some basic utility functions, 
 * **/
public class BRUtil {

	public static boolean emailValidator(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static void main(String args[]) {
		System.out.println(BRUtil.emailValidator("a@bcom"));
	}
}
