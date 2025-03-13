package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

import java.util.Optional;

public class StudyCafePassOrder {

  private final StudyCafeSeatPass seatPass;
  private final StudyCafeLockerPass lockerPass;

  private StudyCafePassOrder(StudyCafeSeatPass seatPass, StudyCafeLockerPass lockerPass) {
    this.seatPass = seatPass;
    this.lockerPass = lockerPass; // null 허용 가능하도록 처리
  }


  public static StudyCafePassOrder of(StudyCafeSeatPass seatPass, StudyCafeLockerPass lockerPass) {
    return new StudyCafePassOrder(seatPass,lockerPass);
  }

  public int getTotalPrice() {
    int lockerPassPrice = lockerPass != null ? lockerPass.getPrice() : 0;
    int totalPassPrice = seatPass.getPrice() + lockerPassPrice;

    return totalPassPrice - getDiscountPrice();
  }

  public int getDiscountPrice() {
    return seatPass.getDiscountPrice();
  }

  public StudyCafeSeatPass getSeatPass() {
    return this.seatPass;
  }

  public Optional<StudyCafeLockerPass> getLockerPass() {
    return Optional.ofNullable(lockerPass);
  }

}
