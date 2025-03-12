package cleancode.studycafe.tobe02.io;

import cleancode.studycafe.tobe02.exception.AppException;
import cleancode.studycafe.tobe02.model.StudyCafePass;
import cleancode.studycafe.tobe02.model.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public class InputHandler {

  private static final Scanner SCANNER = new Scanner(System.in);

  public StudyCafePassType getPassTypeSelectingUserAction() {
    String userInput = getUserInput();

    if ("1".equals(userInput)) {
      return StudyCafePassType.HOURLY;
    }
    if ("2".equals(userInput)) {
      return StudyCafePassType.WEEKLY;
    }
    if ("3".equals(userInput)) {
      return StudyCafePassType.FIXED;
    }
    throw new AppException("잘못된 입력입니다.");
  }

  public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
    String userInput = getUserInput();
    int selectedIndex = Integer.parseInt(userInput) - 1;
    return passes.get(selectedIndex);
  }

  public boolean getLockerSelection() {
    String userInput = getUserInput();
    return "1".equals(userInput);
  }

  private static String getUserInput() {
    String userInput = SCANNER.nextLine();
    return userInput;
  }

}
