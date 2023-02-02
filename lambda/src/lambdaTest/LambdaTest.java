package lambdaTest;

public class LambdaTest {
	public static void main(String[] args) {
//		익명클래스를 사용하거나 람다식을 사용하는 것에 있어서 동작 원리는 전혀 차이가 없다.
//		그렇기에 더 간겨란 람다를 선호한다.
//		LamdaInter lamdaInter= new LamdaInter() {
//
//			@Override
//			public boolean checkMultipleOf10(int number) {
//				return number % 10;
//			}
//			
//		}
		
		LamdaInter lamdaInter= n -> n % 10 ==0;
		System.out.println(lamdaInter.checkMultipleOf10(0));
	}
}
