package br.com.vainaweb.backendt2.atividade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DevFrontEnd extends Collaborator {

	private static final double SALARY_INCREASE = 1.5;

	private List<String> stacks;

	public DevFrontEnd(String name, String identify, double salary, SeniorityLevel seniority, HiringModel hiringModel,
			List<String> stacks, Gender gender) {
		super(name, identify, salary, seniority, hiringModel, gender);
		this.stacks = new ArrayList<>(stacks);
	}

	@Override
	protected double calculateNewSalary() {
		return getSalary() * SALARY_INCREASE;
	}

	public List<String> getStacks() {
		return Collections.unmodifiableList(stacks);
	}

	public void addStacks(String stack) {
		this.stacks.add(stack);
	}

	@Override
	public String toString() {
		return String.format("%s\nStacks: %s", super.toString(), stacks.stream().collect(Collectors.joining(", ")));
	}

	@Override
	protected Function getFunction() {
		return Function.FRONTEND;
	}
}
