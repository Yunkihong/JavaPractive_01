package interfaceTest;

public class Dog implements Animal {

	@Override
	public void sitDown() {
		// TODO Auto-generated method stub
		System.out.println("앉는다.");
	}

	@Override
	public void showHands() {
		// TODO Auto-generated method stub
		System.out.println("손을 준다.");
	}

	@Override
	public void touchNose() {
		// TODO Auto-generated method stub
		System.out.println("코를 준다");
	}

	@Override
	public void waitNow() {
		// TODO Auto-generated method stub
		System.out.println("기다린다.");
	}

	@Override
	public void poop() {
		// TODO Auto-generated method stub
		System.out.println("정해진 장소에서 해결한다.");
	}

}
