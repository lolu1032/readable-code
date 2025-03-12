package cleancode.studycafe.tobe02.model;

import java.util.ArrayList;
import java.util.List;

public class StudyCafePassList {
  private final List<StudyCafePass> passes;
  private final List<StudyCafeLockerPass> lockerPasses;

  public StudyCafePassList(List<StudyCafePass> passes, List<StudyCafeLockerPass> lockerPasses) {
    this.passes = new ArrayList<>(passes);
    this.lockerPasses = new ArrayList<>(lockerPasses);
  }
}
