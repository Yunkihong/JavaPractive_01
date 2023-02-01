package markerInterfaceTest;


public class Lab {
	public void checkKinds(Animal[] animals) {
		for (int i = 0; i < animals.length; i++) {
			if(animals[i] instanceof CanivoreMarker) {
				System.out.println("육식동물");
			}else if(animals[i] instanceof HabivoreMarker) {
				System.out.println("초식동물");
			}else {
				System.out.println("잡식동물");
			}
			
		}
		}
		public static void Main(String[] args) {
		Animal[] animals = {
				new Cow(),
				new Dog(),
				new Tiger(),
				new Bear(),
		}
		
	}
}
