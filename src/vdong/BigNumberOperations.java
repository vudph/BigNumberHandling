package vdong;

public class BigNumberOperations {
	private static int compare(String a, String b) {
		while(a.length() < b.length()) {
			a = '0' + a;
		}
		while(b.length() < a.length()) {
			b = '0' + b;
		}
		return a.compareTo(b); // a = b => -1; a > b => positive number; a < b => negative number
	}
	
	private static String add(String a, String b) {
		int carry = 0;
		String c = "";
		while(a.length() < b.length()) {
			a = '0' + a;
		}
		while(b.length() < a.length()) {
			b = '0' + b;
		}
		int sum = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i));
			sum += carry;
			carry = sum / 10;
			c = Integer.toString(sum % 10) + c;
		}
		if (carry > 0) {
			c = '1' + c;
		}
		return c;
	}
	
	private static String substract(String a, String b) {
		int borrow = 0;
		String c = "";
		String negative = null;
		while(a.length() < b.length()) {
			a = '0' + a;
		}
		while(b.length() < a.length()) {
			b = '0' + b;
		}
		int comp = a.compareTo(b);
		if (comp < 0) {
			String tmp = a;
			a = b;
			b = tmp;
			negative = "-";
		} else if (comp == 0) {
			return "0";
		}
		int s;
		for (int i = a.length() - 1; i >= 0; i--) {
			s = Character.getNumericValue(a.charAt(i)) - Character.getNumericValue(b.charAt(i)) - borrow;
			if (s < 0) {
				s = s + 10;
				borrow = 1;
			} else {
				borrow = 0;
			}
			c = Integer.toString(s) + c;
		}
		while (c.length() > 1 && c.charAt(0) == '0')
			c = c.substring(1);
		if(negative != null) {
			return negative + c;
		} else {
			return c;
		}
	}
	
	private static String multiply0(String a, int b) {
		String c = "";
		int carry = 0;
		int s;
		for (int i = a.length() - 1; i >= 0; i--) {
			s = Character.getNumericValue(a.charAt(i)) * b + carry;
			carry = s / 10;
			c = Integer.toString(s % 10) + c;
		}
		String tmp = "";
		if(carry > 0) {
			tmp = Integer.toString(carry);
		}
		return tmp + c;
	}
	
	private static String multiply(String a, String b) {
		String c = "";
		int m = -1;
		String tmp;
		for (int i = a.length() - 1; i >= 0; i--) {
			m++;
			tmp = multiply0(b, Character.getNumericValue(a.charAt(i)));
			for (int j = 0; j < m; j++) {
				tmp = tmp + "0";
			}
			c = add(tmp, c);
		}
		return c;
	}
	
	private static String div1(String a, int b) {
		String c = "";
		int hold = 0;
		int s = 0;
		for (int i = 0; i < a.length(); i++) {
			hold = hold * 10 + Character.getNumericValue(a.charAt(i));
			s = hold / b;
			hold = hold % b;
			c = c + Integer.toString(s);
		}
		while (c.length() > 1 && c.charAt(0) == '0') {
			c = c.substring(1);
		}
		return c;
	}
	
	private static long mod1(String a, int b) {
		long hold = 0;
		for (int i = 0; i < a.length(); i++) {
			hold = (Character.getNumericValue(a.charAt(i)) + (hold * 10)) % b;
		}
		return hold;
	}
	
	private static String factorial(int n){
		String f = "1";
		for (int i = 1; i <= n; i++) {
			f = multiply0(f, i);
		}
		return f;
	}

	public static void main(String[] args) {
//		System.out.println(compare("36436345645576567567567456453634634664476752323", "56745673474524234758786345344645756856834347453463"));
//		System.out.println(add("36436345645576567567567456453634634664476752323", "56745673474524234758786345344645756856834347453463"));
//		System.out.println(substract("36436345645576567567567456453634634664476752323", "263236345645576567567567456453634634664476752456456"));
		System.out.println(factorial(100));
//		System.out.println(multiply("36436345645576567567567456453634634664476752323", "56745673474524234758786345344645756856834347453463"));
		System.out.println(div1("2342345234535", 23));
		System.out.println(mod1("234234523453544564754674567547546723423445646", 653563645));
		
	}
}
