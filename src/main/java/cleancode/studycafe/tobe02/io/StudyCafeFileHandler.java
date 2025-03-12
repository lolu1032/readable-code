package cleancode.studycafe.tobe02.io;

import cleancode.studycafe.tobe02.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe02.model.StudyCafePass;
import cleancode.studycafe.tobe02.model.StudyCafePassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileHandler {

  public List<StudyCafePass> readStudyCafePasses() {
    try {
      List<String> lines = Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/pass-list.csv"));
      List<StudyCafePass> studyCafePasses = new ArrayList<>();
      for (String line : lines) {
        StudyCafePass studyCafePass = getStudyCafePass(line);
        studyCafePasses.add(studyCafePass);
      }

      return studyCafePasses;
    } catch (IOException e) {
      throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
    }
  }


  public List<StudyCafeLockerPass> readLockerPasses() {
    try {
      List<String> lines = Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/locker.csv"));
      List<StudyCafeLockerPass> lockerPasses = new ArrayList<>();
      for (String line : lines) {
        StudyCafeLockerPass lockerPass = getStudyCafeLockerPass(line);
        lockerPasses.add(lockerPass);
      }

      return lockerPasses;
    } catch (IOException e) {
      throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
    }
  }

  private static StudyCafePass getStudyCafePass(String line) {
    String[] values = line.split(",");
    StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
    int duration = Integer.parseInt(values[1]);
    int price = Integer.parseInt(values[2]);
    double discountRate = Double.parseDouble(values[3]);

    StudyCafePass studyCafePass = StudyCafePass.of(studyCafePassType, duration, price, discountRate);
    return studyCafePass;
  }

  private static StudyCafeLockerPass getStudyCafeLockerPass(String line) {
    String[] values = line.split(",");
    StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
    int duration = Integer.parseInt(values[1]);
    int price = Integer.parseInt(values[2]);

    StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(studyCafePassType, duration, price);
    return lockerPass;
  }

}
