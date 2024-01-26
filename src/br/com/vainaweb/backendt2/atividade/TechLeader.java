package br.com.vainaweb.backendt2.atividade;

public class TechLeader extends Collaborator{

	private static final double SALARY_INCREASE = 1.7;

	public TechLeader(String name, String identify, double salary, SeniorityLevel seniority, HiringModel hiringModel, Gender gender) {
		super(name, identify, salary, seniority, hiringModel, gender);
	}

	@Override
	protected double calculateNewSalary() {
		return getSalary() * SALARY_INCREASE;
	}

	@Override
	protected Function getFunction() {
		return Function.TECHLEADER;
	}

}
