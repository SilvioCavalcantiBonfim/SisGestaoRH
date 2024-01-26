package br.com.vainaweb.backendt2.atividade;

public enum Gender {
  MALE("Masculino"),
  FEMALE("Feminino"),
  NON_BINARY("Não binario"),
  PREFER_NOT_TO_SAY("Prefere não informar");

  private final String gender;

  private Gender(String gender) {
    this.gender = gender;
  }

  public String toString(){
    return gender;
  }
}
