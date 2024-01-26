package br.com.vainaweb.backendt2.atividade;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Salary {
  
  private double salary;
  private Double[] tranche = new Double[]{0.0, 0.0}; 
  
  public Salary(double initialSalary){
    LocalDate.now();
    salary = initialSalary;
    tranche[0] = initialSalary/2;
    tranche[1] = initialSalary/2;
  }

  public double getSalary() {
    return salary;
  }

  public List<Double> getTranche() {
    return Collections.unmodifiableList(Arrays.asList(tranche));
  }

  public void setSalary(double newSalary, LocalDate updateDate){
    if (salary > newSalary) {
      throw new IllegalArgumentException("O novo salário não pode ser inferior ao salário atual.");
    }
    tranche[0] = (afterOctober(updateDate)? salary : newSalary)/2;
    tranche[1] = newSalary/2;
    salary = newSalary;
  }

  private boolean afterOctober(LocalDate updateDate) {
    return updateDate.isAfter(LocalDate.of(LocalDate.now().getYear(), 9, 1));
  }

  
}
