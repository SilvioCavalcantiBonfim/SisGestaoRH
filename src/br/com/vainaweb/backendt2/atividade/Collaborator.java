package br.com.vainaweb.backendt2.atividade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.brazilianchecked.CNPJ;
import br.com.brazilianchecked.CPF;
import br.com.brazilianchecked.TaxId;

public abstract class Collaborator {

	private final UUID id;
	private String name;
	private final TaxId taxId;
	private final LocalDate hiringDate;
	private Gender gender;
	private Salary salary;
	private boolean isActive = true;
	private SeniorityLevel level;
	private HiringModel hiringModel;

	public Collaborator(String name, String taxId, double salary, SeniorityLevel seniority, HiringModel hiringModel, Gender gender) {
		this.id = UUID.randomUUID();
		this.hiringDate = LocalDate.now();
		this.name = name;
		this.gender = gender;
		this.taxId = switch (hiringModel) {
			case CLT -> CPF.parse(taxId);
			case PJ -> CNPJ.parse(taxId);
		};
		if (!this.taxId.isValid()) {
			throw new IllegalArgumentException(String.format("O CPF do colaborador %s é inválido.", name));
		}
		this.salary = new Salary(salary);
		this.level = seniority;
		this.hiringModel = hiringModel;
	}

	public Collaborator(String id, String name, String cpf, double salary, SeniorityLevel seniority,
			HiringModel hiringModel, Gender gender) {
		this.id = UUID.fromString(id);
		this.name = name;
		this.gender = gender;
		this.hiringDate = LocalDate.now();
		this.taxId = CPF.parse(cpf);
		if (!this.taxId.isValid()) {
			throw new IllegalArgumentException("O CPF do colaborador é inválido.");
		}
		this.salary = new Salary(salary);
		this.level = seniority;
		this.hiringModel = hiringModel;
	}
	
	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getTaxId() {
		return taxId.toString();
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isAtivo) {
		this.isActive = isAtivo;
	}

	public String getLevel() {
		return level.toString();
	}

	public String getHiringModel() {
		return hiringModel.toString();
	}

	public void setHiringModel(HiringModel hiringModel) {
		this.hiringModel = hiringModel;
	}

	public double getSalary() {
		return salary.getSalary();
	}

	public List<Double> getTranche() {
		if (hiringModel.equals(HiringModel.PJ)) {
			throw new UnsupportedOperationException("Contratação PJ não possui 13 salário.");
		}
		return salary.getTranche();
	}

	public void updateLevel() {
		level = level.nextLevel();
	}

	public void desvincularColaborador() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tem certeza que deseja desvincular " + this.name);
		Character resposta = sc.next().toLowerCase().charAt(0);
		if (resposta.equals('s')) {
			this.isActive = false;
			System.out.println("Você está demitido!!!!!!");
		}
		sc.close();
	}

	public void incrementSalary() {
		salary.setSalary(calculateNewSalary(), LocalDate.now());
	}

	public void promote() {
		level = level.nextLevel();
		incrementSalary();
	}

	protected abstract double calculateNewSalary();

	protected abstract Function getFunction();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ").append(id.toString())
				.append("\nNome: ").append(name)
				.append("\nGênero: ").append(gender)
				.append("\nData de contratação: ").append(hiringDate.format(DateTimeFormatter.ofPattern("d MMM uuuu")))
				.append("\nModelo de contratação: ").append(hiringModel)
				.append(switch(hiringModel){
					case CLT -> "\nCPF: ";
					case PJ -> "\nCNPJ: ";
				})
				.append(taxId)
				.append("\nSalário: R$ ").append(String.format("%.2f", salary.getSalary()));

		if (hiringModel.equals(HiringModel.CLT)) {
			sb.append("\nParcelas do 13 salário até a data ")
				.append(LocalDate.now().format(DateTimeFormatter.ofPattern("d MMM uuuu")))
				.append(": R$").append(salary.getTranche().stream().map(Object::toString).collect(Collectors.joining(", R$ ")));
		}

		sb.append("\nEstado: ").append(isActive ? "Ativo" : "Inativo")
				.append("\nCargo: ").append(getFunction())
				.append("\nSenioridade: ").append(level);


		return sb.toString();

	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public void setLevel(SeniorityLevel level) {
		this.level = level;
	}

	public LocalDate getHiringDate() {
		return hiringDate;
	}


}
