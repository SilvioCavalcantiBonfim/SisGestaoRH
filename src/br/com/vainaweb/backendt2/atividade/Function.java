package br.com.vainaweb.backendt2.atividade;

public enum Function {
  DESIGNER("Designer"), 
  FRONTEND("Desenvolvedor Front-End"), 
  BACKEND("Desenvolvedor Back-End"),
  TECHLEADER("TechLeader");

  private final String function;

  private Function(String function) {
    this.function = function;
  }

  @Override
  public String toString() {
    return function;
  }

}
