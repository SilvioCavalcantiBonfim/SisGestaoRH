package br.com.vainaweb.backendt2.atividade;

import java.util.List;
import java.util.Random;

public class App {

        private static List<Designer> designers = List.of(
                        new Designer("Cecília Alice Pinto", "80.704.690/0001-07", 3046.0, SeniorityLevel.PLENO,
                                        HiringModel.PJ, Gender.FEMALE),
                        new Designer("João Miguel da Silva", "412.347.744-53", 3500.0, SeniorityLevel.JUNIOR,
                                        HiringModel.CLT, Gender.MALE),
                        new Designer("Maria Clara Santos", "24.706.325/0001-52", 4000.0, SeniorityLevel.SENIOR,
                                        HiringModel.PJ, Gender.FEMALE),
                        new Designer("Pedro Henrique de Souza", "173.787.794-58", 4500.0, SeniorityLevel.PLENO,
                                        HiringModel.CLT, Gender.MALE),
                        new Designer("Ana Julia Oliveira", "67.007.061/0001-51", 5000.0, SeniorityLevel.SENIOR,
                                        HiringModel.PJ, Gender.FEMALE));

        private static List<DevBackEnd> devsBackend = List.of(
                        new DevBackEnd("Cláudio Mateus da Cruz", "090.055.124-07", 12292.0, SeniorityLevel.SENIOR,
                                        HiringModel.CLT, List.of("Java", "GO", "Node.JS"), Gender.NON_BINARY),
                        new DevBackEnd("João Miguel da Silva", "813.962.754-28", 13000.0, SeniorityLevel.JUNIOR,
                                        HiringModel.CLT, List.of("Python", "Django"), Gender.PREFER_NOT_TO_SAY),
                        new DevBackEnd("Maria Clara Santos", "62.882.257/0001-71", 14000.0, SeniorityLevel.SENIOR,
                                        HiringModel.PJ,
                                        List.of("JavaScript", "Nest"), Gender.FEMALE),
                        new DevBackEnd("Pedro Henrique de Souza", "139.055.354-08", 15000.0, SeniorityLevel.PLENO,
                                        HiringModel.CLT, List.of("Java", "Spring Boot"), Gender.NON_BINARY),
                        new DevBackEnd("Ana Julia Oliveira", "67.123.933/0001-47", 16000.0, SeniorityLevel.SENIOR,
                                        HiringModel.PJ,
                                        List.of("Python", "Flask"), Gender.FEMALE));

        private static List<DevFrontEnd> devsFrontend = List.of(
                        new DevFrontEnd("Henry Rafael Duarte", "901.515.574-70", 7815.0, SeniorityLevel.PLENO,
                                        HiringModel.CLT,
                                        List.of("React", "Angular", "Vue"), Gender.MALE),
                        new DevFrontEnd("João Miguel da Silva", "169.303.804-82", 8000.0, SeniorityLevel.JUNIOR,
                                        HiringModel.CLT, List.of("Vue", "Ember"), Gender.MALE),
                        new DevFrontEnd("Maria Clara Santos", "61.429.678/0001-89", 8500.0, SeniorityLevel.SENIOR,
                                        HiringModel.PJ,
                                        List.of("Angular", "React"), Gender.FEMALE),
                        new DevFrontEnd("Pedro Henrique de Souza", "252.627.264-53", 9000.0, SeniorityLevel.PLENO,
                                        HiringModel.CLT, List.of("React", "Vue"), Gender.MALE),
                        new DevFrontEnd("Ana Julia Oliveira", "67.159.027/0001-00", 9500.0, SeniorityLevel.SENIOR,
                                        HiringModel.PJ,
                                        List.of("Angular", "Ember"), Gender.FEMALE));

        private static List<TechLeader> techLeaders = List.of(
                        new TechLeader("Hadassa Daniela Gonçalves", "02.314.973/0001-20", 3815.0, SeniorityLevel.JUNIOR,
                                        HiringModel.PJ, Gender.NON_BINARY),
                        new TechLeader("João Miguel da Silva", "021.626.654-84", 8000.0, SeniorityLevel.JUNIOR,
                                        HiringModel.CLT, Gender.MALE),
                        new TechLeader("Maria Clara Santos", "82.792.618/0001-04", 8500.0, SeniorityLevel.SENIOR,
                                        HiringModel.PJ, Gender.FEMALE),
                        new TechLeader("Pedro Henrique de Souza", "562.498.744-70", 9000.0, SeniorityLevel.PLENO,
                                        HiringModel.CLT, Gender.MALE),
                        new TechLeader("Ana Julia Oliveira", "63.396.674/0001-77", 9500.0, SeniorityLevel.SENIOR,
                                        HiringModel.PJ, Gender.FEMALE));

        public static void main(String[] args) throws Exception {

                Random rng = new Random();

                Designer designer = designers.get(rng.nextInt(designers.size()));

                DevBackEnd backend = devsBackend.get(rng.nextInt(designers.size()));

                DevFrontEnd frontend = devsFrontend.get(rng.nextInt(designers.size()));

                TechLeader techLeader = techLeaders.get(rng.nextInt(designers.size()));

                List<Collaborator> team = List.of(designer, backend, frontend, techLeader);

                System.out.println(
                                "-----------------------------------------------------------------\n----------------- Time antes do desenvolvimento -----------------");

                team.forEach(e -> System.out
                                .printf("-----------------------------------------------------------------\n%s\n", e));

                System.out.println(
                                "-----------------------------------------------------------------\n------------------ Time após o desenvolvimento ------------------");

                team.stream().map(e -> {
                        e.promote();
                        return e;
                }).forEach(e -> System.out
                                .printf("-----------------------------------------------------------------\n%s\n", e));
        }
}