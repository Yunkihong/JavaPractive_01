package interfaceTest;

public interface Animal{
	int eyes = 2;// == final static int eyes = 2;
	
	abstract void sitDown();
	void showHands();// 추상메소드 밖에 안되니 생략 가능
	void touchNose();
	void waitNow();
	void poop();
	
}
