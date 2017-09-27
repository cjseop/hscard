package Level3;

/*
 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 
다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
A를 3만큼 밀면 D가 되고 z를 1만큼 밀면 a가 됩니다. 
공백은 수정하지 않습니다.
보낼 문자열 s와 얼마나 밀지 알려주는 n을 입력받아 암호문을 만드는 
ceasar 함수를 완성해 보세요.
“a B z”,4를 입력받았다면 “e F d”를 리턴합니다.
 */
public class Caesar {
	String caesar(String s, int n) {
		char[] charArr = s.toCharArray();
		String result = "";
		int mod = n % 26;
		for (int i = 0; i < charArr.length; i++) {
			int su = charArr[i] + mod;
			if(charArr[i] == 32){
				
			}else if(Character.isUpperCase(charArr[i])){
				while(su > 90){
					su = su - 90 + 64;
				}
				charArr[i] = (char)su;
			}else{
				while(su > 122){
					su = su - 122 + 96;
				}
				charArr[i] = (char)su;
			}
		}
		
		for (int i = 0; i < charArr.length; i++) {
			result += charArr[i];
			
		}
		
		return result;
		
		
		  /*n = n % 26;
		    for (int i = 0; i < s.length(); i++) {
		      char ch = s.charAt(i);
		      if (Character.isLowerCase(ch)) {
		        ch = (char) ((ch - 'a' + n) % 26 + 'a');
		      } else if (Character.isUpperCase(ch)) {
		        ch = (char) ((ch - 'A' + n) % 26 + 'A');
		      }
		      result += ch;
		    } */
	}

	public static void main(String[] args) {
		Caesar c = new Caesar();
		System.out
				.println("s는 'Z B z', n은 4인 경우: " + c.caesar("ASNWeapguDZkR SDL okducxEEINgpgLSAOOFGqZVbiKcBTMbs",35));
	}
}
