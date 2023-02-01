package bank;

public class KaKao extends Bank{
//	잔액조회시 잔액 1/2
   @Override
   public int showBalance() {
      this.money /= 2;
      return super.showBalance();
   }
}