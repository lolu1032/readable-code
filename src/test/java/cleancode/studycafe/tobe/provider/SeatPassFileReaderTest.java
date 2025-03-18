package cleancode.studycafe.tobe.provider;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPasses;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPasses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeatPassFileReaderTest {
  public static final String PASS_LIST_CSV_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";
  @DisplayName("SeatPass CSV 파일 읽어서 객체가 생겼는지 테스트")
  @Test
  void test() {
      // given
    SeatPassFileReader reader = new SeatPassFileReader() {
      @Override
      public StudyCafeSeatPasses getSeatPasses() {
        try {
          List<String> lines = Files.readAllLines(Paths.get(PASS_LIST_CSV_PATH));
          List<StudyCafeSeatPass> studyCafeSeatPasses = new ArrayList<>();
          for (String line : lines) {
            String[] values = line.split(",");
            StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
            int duration = Integer.parseInt(values[1]);
            int price = Integer.parseInt(values[2]);
            double discountRate = Double.parseDouble(values[3]);

            StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(studyCafePassType, duration, price, discountRate);
            studyCafeSeatPasses.add(studyCafeSeatPass);
          }

          return StudyCafeSeatPasses.of(studyCafeSeatPasses);
        } catch (IOException e) {
          throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
      }
    };
      // when
      StudyCafeSeatPasses lockerPasses = reader.getSeatPasses();
      // then
      assertThat(lockerPasses).isNotNull();
  }
}
