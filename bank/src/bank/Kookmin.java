package bank;

public class Kookmin extends Bank {
//출금시 수수료 50%
   @Override
   public void withdraw(int money) {
      money *= 1.5;
      super.withdraw(money);
   }
}