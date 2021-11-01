import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVWriterFiles {
    private static void input(Scanner scanner, List<Pokemon> pokemons){
        while (true) {
            System.out.println("1 - Add pokemon\n2 - Sair");
            String input = scanner.nextLine();

            if(input.equals("2")) {
                System.out.println("Valeu pelo teste ;)");
                scanner.close();
                break;
            }else {
                System.out.println("Nome do pokémon:");
                String nome = scanner.nextLine();

                System.out.println("\nTipo:");
                String tipo = scanner.nextLine();

                System.out.println("\nAtaque:");
                String ataque = scanner.nextLine();

                System.out.println("\nDano:");
                String dano = scanner.nextLine();

                System.out.println("\nResistencia:");
                String resistencia = scanner.nextLine();

                pokemons.add(new Pokemon(
                        nome,
                        tipo,
                        Integer.parseInt(ataque),
                        Integer.parseInt(dano),
                        Integer.parseInt(resistencia)));
            }
        }
    }

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> pokemons = new ArrayList<>();
        input(scanner, pokemons);
        File f = new File("C:\\Users\\Camila\\IdeaProjects\\Trabalho_Pratico_01\\pokemons.csv");

        if(f.exists() && !f.isDirectory()) {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("pokemons.csv", true), StandardCharsets.UTF_8));
            bw.write(String.valueOf(pokemons.toString()
                    .replace("[", "")
                    .replace("]","")));
            bw.close();
        }else {
            Writer writer = Files.newBufferedWriter(Paths.get("pokemons.csv"));
            writer.append("\"Nome\", \"Tipo\", \"Ataque\", \"Dano\", \"Resistencia\"\n");
            StatefulBeanToCsvBuilder<Pokemon> beanToCsv = new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<Pokemon> beanWriter = beanToCsv.build();
            beanWriter.write(pokemons);
            writer.close();
        }
        scanner.close();
    }
}

