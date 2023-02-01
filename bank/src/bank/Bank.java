package bank;

public class Bank {

//   예금주
   private String name;
//   계좌번호
   private String account;
//   핸드폰번호
   private String phoneNumber;
//   비밀번호
   private String password;
//   통장 
//   자식에게는 접근할 수 있도록 protected로 
   protected int money;
   
   public Bank() {;}
// ctrl+shift+s 해서 generate getter and setter
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAccount() {
      return account;
   }

   public void setAccount(String account) {
      this.account = account;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public int getMoney() {
      return money;
   }

   public void setMoney(int money) {
      this.money = money;
   }

//   *static
//   계좌번호 중복검사
   public final static Bank checkAccount(Bank[][] arrBank, int[] arCount, String account) {
      Bank bank = null;
//  	3개의 은행 반복 
      for (int i = 0; i < arrBank.length; i++) {
//      밖에서도 쓰기위해 바깥에 변수j를 선언
    	  int j = 0;
//        각각은행의 고객수만큼 반복
         for (j = 0; j < arCount[i]; j++) {
//          계정 자체를 기져와 비교 후 break
        	 if(arrBank[i][j].getAccount().equals(account)) {
               bank = arrBank[i][j];
               break;
            }
         }
//       만약j가 끝까지 됼았다면 다돌고 그냥 나왔겠지만, j가 break를 만났더면 중복이 되었다는 것.그렇다면 이 바깥쪽 반복문도 끝내주어야한다. 
         if(j != arCount[i]) {
            break;
         }
      }
//   추후에 재사용을 하기 위해 bank로 리턴.   
      return bank;
   }
   
   
//   핸드폰번호 중복검사 위와 같음
   public final static Bank checkPhoneNumber(Bank[][] arrBank, int[] arCount, String phoneNumber) {
      Bank bank = null;
      
      for (int i = 0; i < arrBank.length; i++) {
         int j = 0;
         for (j = 0; j < arCount[i]; j++) {
            if(arrBank[i][j].getPhoneNumber().equals(phoneNumber)) {
               bank = arrBank[i][j];
               break;
            }
         }
         if(j != arCount[i]) {
            break;
         }
      }
      
      return bank;
   }
   
//   로그인
//   객체의 정보를 전부 받아와 사용.
   public final static Bank login(Bank[][] arrBank, int[] arCount, String account, String password) {
// checkAccount를 받아와  
	   Bank user = checkAccount(arrBank, arCount, account);
//      사용자가 있는지
	   if(user != null) {
//        그 사용자의 비밀번호가 일치하는지
		   if(user.password.equals(password)) {
//            로그인 성공
			   return user;
         }
      }
//	   실패
      return null;
   }
   
//   *일반
//   입금
   public void deposit(int money) {
      this.money += money;
   }
   
//   출금
   public void withdraw(int money) {
      this.money -= money;
   }
   
// 	 나중에 유지보수를 위해 만들어놓은 모습
//   잔액조회
   public int showBalance() {
      return money;
   }
   
}
































