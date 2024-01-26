package br.com.vainaweb.backendt2.atividade;

public class Designer extends Collaborator{
	
	private static final double SALARY_INCREASE = 1.4;

	public Designer(String name, String identify, double salary, SeniorityLevel seniority, HiringModel hiringModel, Gender gender) {
		super(name, identify, salary, seniority, hiringModel, gender);
	}

	@Override
	protected double calculateNewSalary() {
		return getSalary()*SALARY_INCREASE;
	}

	@Override
	protected Function getFunction() {
		return Function.DESIGNER;
	}
}
