package lambdaTask;

public class Test {
	public static void main(String[] args) {
		String [] allll ="1 + 2".split("\\+ | \\-");
		for (int i = 0; i < allll.length; i++) {
			System.out.print(allll[i]+" ");
		}
	}
}
