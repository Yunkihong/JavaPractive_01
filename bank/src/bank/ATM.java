package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
   public static void main(String[] args) {
      
	   String[] bankNames = {"신한은행", "국민은행", "카카오뱅크"};
      
	   Bank[][] arrBank = new Bank[3][100];
//    현재 각 은행별 고객 수를 담기위한 객체
      int[] arCount = new int[3];
      
      final int ACCOUNT_LENGTH = 6;
//      선택메세지
      String message = "1. 신한은행\n2. 국민은행\n3. 카카오뱅크\n4. 나가기";
      
      String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행 선택 메뉴로 돌아가기";
      Scanner sc = new Scanner(System.in);
      Random random = new Random();
      String account = "", password = null, phoneNumber = null;
      Bank user = null;
      int money = 0;
      
      int i = 0, choice = 0;
      
      
      while(true) { 
         System.out.println(message);
         i = sc.nextInt();
//         나가기
         if(i == 4) {
        	 System.out.println("안녕히 가세요");
        	 break;
         }
//         1이하4이상 입력시 다시 입력
         else if(i<1||i>4){
        	 System.out.println("다시 입력해주세요");
        	 break;
         }
//         인덱스 숫자에 맞춰 -1
         i--;
         
         while(true) {
//        	 은행들의 특징성 부여
            Bank[] banks = {new Shinhan(), new Kookmin(), new KaKao()};
            
            System.out.println(menu);
            choice = sc.nextInt();
//            6번 누르면 나가기
            if(choice == 6) {break;}
            
            switch(choice) {
            case 1: // 계좌개설
//            	선택한 i-1번째 은행의 고객수가 100명 이상일 때 하는 예외처리
               if(arCount[i] == 100) {System.out.println("더 이상 계좌를 개설할 수 없는 은행입니다."); break;}
//             banks배열에 user정보를 담아줌
               user = banks[i];
//           계속 돌면서 account에 수가 쌓이는 것을 방지하기 위해 변수 초기화    
               account = "";
               
               while(true) {
   //               계좌번호가 0부터 시작 가능
   //               for (int j = 0; j < ACCOUNT_LENGTH; j++) {
   //                  account += random.nextInt(10);
   //               }
                  
   //               계좌번호가 1부터 시작 가능
   //               100000 ~ 999999 -> 0 ~ 899999
            	   
                  account += random.nextInt(900000) + 100000;
//                계좌번호 앞에 은행의 인덱스번호+1을 추가
                  account = i + 1 + account;
//               계좌번호 랜덤생성 후 중복검사.checkAccount로 아이디를 가져와 id가 null값이라면 통과. 
                  if(Bank.checkAccount(arrBank, arCount, account) == null) {
                     break;
                  }
               }
//              계좌번호를 유저의 계좌번호로 저장
               user.setAccount(account);
//               예금주입력
               System.out.print("예금주: ");
               user.setName(sc.next());
               
               while(true) {
                  System.out.print("비밀번호[4자리]: ");
                  password = sc.next();
                  
                  if(password.length() == 4) {break;}
               }
               
               user.setPassword(password);
               
               while(true) {
                  System.out.print("핸드폰 번호['-' 제외]");
                  phoneNumber = sc.next();
//                 replaceAll 함수로 - 를 빈자리로 만들기
                  phoneNumber = phoneNumber.replaceAll("-", "");
//                 휴대폰번호 자리수가 11자리가 아니거나, 중복이 아니어야함.
                  if(phoneNumber.length() == 11 && Bank.checkPhoneNumber(arrBank, arCount, phoneNumber) == null) {break;}
               }
//              사용자에 휴대폰번호 저장
               user.setPhoneNumber(phoneNumber);
//               사용자를 은행배열에 넣기
               arrBank[i][arCount[i]] = user;
//           	사용자 한명이 늘었으니 한명 추가
               arCount[i]++;
               
               System.out.println(bankNames[i] +" "+user.getName()+ " 고객님, 환영합니다.");
               System.out.println("고객님의 계좌번호: \""+ account+"\" 입니다");
               
               break;
            case 2: // 입금하기
               System.out.print("계좌번호: ");
               account = sc.next();
               
               System.out.print("비밀번호: ");
               password = sc.next();
               
               // 저장소와 고객수, 입력받은 계좌번호와 비밀번호를 전달하면
               // 로그인 검사를 통해 로그인 성공 시 회원 객체를 전달해준다.
               user = Bank.login(arrBank, arCount, account, password);
               if(user != null) {
                  if(user.getAccount().charAt(0) - 48 == i + 1) {
                     System.out.print("입금액: ");
                     money = sc.nextInt();
                     System.out.println(money+"원이 입금되었습니다.");
                     if(money <= 0) {
                        System.out.println("다시 입력해주세요.");
                        break;
                     }
                     
                     user.deposit(money);
                  }else {
                     System.out.println("개설한 은행에서만 입금이 가능합니다.");
                  }
                  
                  
//                  boolean flag = false;
////                  고객의 은행이 무슨 은행인지, 지금 선택한 은행이 무슨 은행인지
//                  if(user instanceof Shinhan) {
//                     if(i == 0) {
//                        flag = true;
//                     }
//                  }else if(user instanceof Kookmin) {
//                     if(i == 1) {
//                        flag = true;
//                     }
//                  }else {
//                     if(i == 2) {
//                        flag = true;
//                     }
//                  }
//                  if(flag) {
//                     System.out.print("입금액: ");
//                     money = sc.nextInt();
//                     if(money <= 0) {
//                        System.out.println("다시 입력해주세요.");
//                        break;
//                     }
//                     
//                     user.deposit(돈);
//                  }else {
//                     System.out.println("개설한 은행에서만 입금이 가능합니다.");
//                  }
               }
               
               break;
            case 3: // 출금하기
               System.out.print("계좌번호: ");
               account = sc.next();
               
               System.out.print("비밀번호: ");
               password = sc.next();
               
               user = Bank.login(arrBank, arCount, account, password);
               
               if(user != null) {
                  System.out.print("출금액: ");
                  money = sc.nextInt();
                  if(user.getMoney() < (user instanceof Kookmin ? money * 1.5 : money)) {
                     System.out.println("잔액 부족");
                     break;
                  }
                  user.withdraw(money);
               }
               break;
            case 4: // 잔액조회
               System.out.print("계좌번호: ");
               account = sc.next();
               
               System.out.print("비밀번호: ");
               password = sc.next();
               
               user = Bank.login(arrBank, arCount, account, password);
               
               if(user != null) {
                  System.out.println("현재 잔액: " + user.showBalance() + "원");
               }
               
               break;
            case 5: // 계좌번호 찾기
               System.out.print("핸드폰 번호: ");
               phoneNumber = sc.next();
               
               user = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);
               
               if(user != null) {
                  System.out.print("비밀번호: ");
                  password = sc.next();

                  if(user.getPassword().equals(password)) {
                     
                     while(true) {
         //               계좌번호가 0부터 시작 가능
         //               for (int j = 0; j < ACCOUNT_LENGTH; j++) {
         //                  account += random.nextInt(10);
         //               }
                        
         //               계좌번호가 1부터 시작 가능
         //               100000 ~ 999999 -> 0 ~ 899999
                        account += random.nextInt(900000) + 100000;
                        
                        if(Bank.checkAccount(arrBank, arCount, account) == null) {
                           break;
                        }
                     }
                     user.setAccount(account);
                     System.out.println("다시는 잃어버리지 마세요.");
                     System.out.println("너의 계좌번호: " + account);
                  }
               }
               break;
            default :
            	System.out.println("잘못 입력하셨습니다.");
            break;
            }
         }
      }
   }
}

















