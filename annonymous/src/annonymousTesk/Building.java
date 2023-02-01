package annonymousTesk;

public class Building {
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		Starbucks jamsil = new Starbucks();
		
		jamsil.register(new FormAdapter() {

			@Override
			public String[] getMenu() {
				return new String[] { "아메리카노", "카페라떼", "그린티" };
			}
		});
		gangnam.register(new Form() {

			@Override
			public void sell(String order) {
				String[] menu = getMenu();
				for (int i = 0; i < menu.length; i++) {
					if (menu[i].equals(order)) {
						System.out.println(order + "주문완료");
						return;
					}
				}
				System.out.println("없는메뉴입니다.");
			}

			@Override
			public String[] getMenu() {
				return new String[] { "아메리카노", "카페라떼", "그린티" };
			}
		});

	}
}
