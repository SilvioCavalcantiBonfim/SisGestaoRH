package br.com.vainaweb.backendt2.atividade;

import java.util.Arrays;

public enum SeniorityLevel {
  TRAINEE("Trainee", 0),
  JUNIOR("Junior", 1),
  PLENO("Pleno", 2),
  SENIOR("Sênior", 3);

  private final String seniority;
  private final int index;

  SeniorityLevel(String seniority, int index){
    this.seniority = seniority;
    this.index = index;
  }

  public String toString() {
    return seniority.toString();
  }

  public SeniorityLevel nextLevel(){
    final int nextIndex = index + 1;
    return Arrays.asList(SeniorityLevel.values()).stream().filter((e) -> e.index == nextIndex).findFirst().orElse(this);
  }
}
