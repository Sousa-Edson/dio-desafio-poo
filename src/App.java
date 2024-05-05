import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import domain.Bootcamp;
import domain.Conteudo;
import domain.Curso;
import domain.Dev;
import domain.Mentoria;

public class App {
    public static void main(String[] args) throws Exception {
        // Criação dos cursos e mentoria
        Curso curso1 = new Curso("Curso Java", "Descrição do curso Java", 8);
        Curso curso2 = new Curso("Curso JavaScript", "Descrição do curso JavaScript", 4);
        Mentoria mentoria = new Mentoria("Mentoria de Java", "Descrição da mentoria de Java", LocalDate.now());

        // Impressão dos cursos e mentoria
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);

        // Criação do conjunto de conteúdos
        Set<Conteudo> conteudos = new HashSet<>();
        conteudos.add(curso1);
        conteudos.add(curso2);
        conteudos.add(mentoria);

        // Criação do bootcamp
        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição do Bootcamp Java Developer", conteudos);

        // Criação e inscrição de devs no bootcamp
        Dev devDonatello = new Dev("Donatello");
        inscreverDevNoBootcamp(devDonatello, bootcamp);
        progredirDev(devDonatello, 2);

        Dev devMichelangelo = new Dev("Michelangelo");
        inscreverDevNoBootcamp(devMichelangelo, bootcamp);
        progredirDev(devMichelangelo, 3);
    }

    // Método para inscrever dev no bootcamp
    private static void inscreverDevNoBootcamp(Dev dev, Bootcamp bootcamp) {
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
    }

    // Método para progredir dev
    private static void progredirDev(Dev dev, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            dev.progredir();
        }
        System.out.println("-");
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos " + dev.getNome() + ": " + dev.getConteudosConcluidos());
        System.out.println("XP " + dev.getNome() + ": " + dev.calcularTotalXp());
        System.out.println("-------");
    }
}
