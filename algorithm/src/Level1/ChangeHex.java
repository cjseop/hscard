package Level1;

public class ChangeHex {

	public static void main(String[] args) {
		ChangeHex h1 = new ChangeHex();
		h1.makeHex(65535, 2);
	}

	public void makeHex(int su, int jin) {
		int num = su;
		int mok = 0;
		int nam = 0;
		String result = "";
		while (su > 0) {
			mok = su / jin;
			nam = su % jin;
			su = mok;
			if (nam > 9) {
				switch (nam) {
				case 10:
					result += "A";
					break;
				case 11:
					result += "B";
					break;
				case 12:
					result += "C";
					break;
				case 13:
					result += "D";
					break;
				case 14:
					result += "E";
					break;
				case 15:
					result += "F";
					break;
				}
			} else {
				result += nam;
			}

		}
		char a[] = new char[result.length()];
		a = result.toCharArray();
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i]);
		}
	}
}
