package one.digitalinovation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import one.digitalinovation.dominio.Bootcamp;
import one.digitalinovation.dominio.Conteudo;
import one.digitalinovation.dominio.Curso;
import one.digitalinovation.dominio.Dev;
import one.digitalinovation.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso cursoJavaBasico = new Curso();
		cursoJavaBasico.setTitulo("Java Básico");
		cursoJavaBasico.setDescricao("Aprenda os conceitos básicos sobre Java.");
		cursoJavaBasico.setCargaHorária(8);
		
		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo("Java .NET");
		cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre C#.");
		cursoDotNet.setCargaHorária(6);
		
		Curso cursoJavaAvancado = new Curso();
		cursoJavaAvancado.setTitulo("Java Avançado");
		cursoJavaAvancado.setDescricao("Aprenda os conceitos avançados sobre Java.");
		cursoJavaAvancado.setCargaHorária(15);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orientação a Objetos com Java");
		mentoria.setDescricao("Imersão sobre os pilares da Orientação a Objtos.");
		mentoria.setData(LocalDateTime.now());
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("GFT START #2 Java");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(45));
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
		bootcamp.setConteudos(conteudosBootcamp);
		
		Dev nonato = new Dev();
		nonato.setNome("Nonato");
		
		Dev adam = new Dev();
		adam.setNome("Adam");
		
		nonato.inscrever(cursoDotNet);
		nonato.inscrever(bootcamp);
		nonato.progredir();
		nonato.progredir();
		
		adam.inscrever(bootcamp);
		adam.progredir();
		adam.progredir();
		adam.progredir();
		
		System.out.println(String.format("XP Nonato: %.2f", nonato.calcularTotalXp()));
		System.out.println(String.format("XP Adam: %.2f", adam.calcularTotalXp()));
		
		List<Dev> rank = Arrays.asList(nonato, adam).stream()
				.sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
				.collect(Collectors.toList());
		
		for (Dev dev : rank) {
			System.out.println(dev.getNome());
		}

	}

}
