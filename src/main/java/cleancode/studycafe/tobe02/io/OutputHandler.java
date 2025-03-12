package cleancode.studycafe.tobe02.io;

import cleancode.studycafe.tobe02.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe02.model.StudyCafePass;

import java.util.List;

public class OutputHandler {

  public void showWelcomeMessage() {
    welcomeMessage();
  }


  public void showAnnouncement() {
    checkedUseFixLocker();
  }


  public void askPassTypeSelection() {
    checkedPassList();
  }

  public void showPassListForSelection(List<StudyCafePass> passes) {
    passList(passes);
  }

  public void askLockerPass(StudyCafeLockerPass lockerPass) {
    checkedLockerPass(lockerPass);
  }

  public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
    ticketHistory(selectedPass, lockerPass);

    int discountPrice = evnetSale(selectedPass);

    totalPrice(selectedPass, lockerPass, discountPrice);
  }


  public void showSimpleMessage(String message) {
    System.out.println(message);
  }

  private static void welcomeMessage() {
    System.out.println("*** 프리미엄 스터디카페 ***");
  }

  private static void checkedUseFixLocker() {
    System.out.println("* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)");
    System.out.println("* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)");
    System.out.println();
  }

  private static void checkedPassList() {
    System.out.println("사용하실 이용권을 선택해 주세요.");
    System.out.println("1. 시간 이용권(자유석) | 2. 주단위 이용권(자유석) | 3. 1인 고정석");
  }

  private static void passList(List<StudyCafePass> passes) {
    System.out.println();
    System.out.println("이용권 목록");
    for (int index = 0; index < passes.size(); index++) {
      StudyCafePass pass = passes.get(index);
      System.out.println(String.format("%s. ", index + 1) + pass.display());
    }
  }

  private static void checkedLockerPass(StudyCafeLockerPass lockerPass) {
    System.out.println();
    String askMessage = String.format(
      "사물함을 이용하시겠습니까? (%s)",
      lockerPass.display()
    );

    System.out.println(askMessage);
    System.out.println("1. 예 | 2. 아니오");
  }

  private static void ticketHistory(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
    System.out.println();
    System.out.println("이용 내역");
    System.out.println("이용권: " + selectedPass.display());
    if (lockerPass != null) {
      System.out.println("사물함: " + lockerPass.display());
    }
  }

  private static void totalPrice(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass, int discountPrice) {
    int totalPrice = selectedPass.getPrice() - discountPrice + (lockerPass != null ? lockerPass.getPrice() : 0);
    System.out.println("총 결제 금액: " + totalPrice + "원");
    System.out.println();
  }

  private static int evnetSale(StudyCafePass selectedPass) {
    double discountRate = selectedPass.getDiscountRate();
    int discountPrice = (int) (selectedPass.getPrice() * discountRate);
    if (discountPrice > 0) {
      System.out.println("이벤트 할인 금액: " + discountPrice + "원");
    }
    return discountPrice;
  }
}
