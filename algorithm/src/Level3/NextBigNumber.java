package Level3;
/*
 어떤 수 N(1≤N≤1,000,000) 이 주어졌을 때, N의 다음 큰 숫자는 다음과 같습니다.
N의 다음 큰 숫자는 N을 2진수로 바꾸었을 때의 1의 개수와 같은 개수로 이루어진 수입니다.
1번째 조건을 만족하는 숫자들 중 N보다 큰 수 중에서 가장 작은 숫자를 찾아야 합니다.
예를 들어, 78을 2진수로 바꾸면 1001110 이며, 78의 다음 큰 숫자는 83으로 2진수는 1010011 입니다.
N이 주어질 때, N의 다음 큰 숫자를 찾는 nextBigNumber 함수를 완성하세요.
 */
public class NextBigNumber {
	public int nextBigNumber(int n)
    {
        int answer = 0;
        int su = countOne(n);
        for (int i = n + 1; i < 1000000; i++) {
			if(su == countOne(i)){
				answer = i;
				break;
			}
		}
        return answer;
        
//        int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
//        return n + postPattern | smallPattern;
    }
	
	public int countOne(int n){
		int cnt = 0;
		while(n >= 1){
			int mod = n % 2;
			int mok = n / 2;
			n = mok;
			if(mod == 1){
				cnt++;
			}
		}
		return cnt;
	}
	
    public static void main(String[] args)
    {
    	NextBigNumber test = new NextBigNumber();
        int n = 3;
        System.out.println(test.nextBigNumber(n));
    }
}
