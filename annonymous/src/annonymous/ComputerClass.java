package annonymous;

public class ComputerClass {
	public static void main(String[] args) {
//	
		Game rpg = new Game() {

			@Override
			public void play() {
				// TODO Auto-generated method stub
				System.out.println("사냥");
			}

			@Override
			public void exit() {
				// TODO Auto-generated method stub
				System.out.println("조금만 기다리시면 보상이 도착해요");
			}
		};
		
		rpg.play();

	}
}
