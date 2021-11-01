import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Serializer {
    static void writeXML(List<String[]> pokemons) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        for (String[] pokemon : pokemons){
            xmlMapper.writeValue(new FileOutputStream("outputSerialized.xml", true),pokemon);
            File file = new File("output.xml");
        }
        System.out.println("Serialized XML!");
    }

    static void writeJSON(List<String[]> pokemons) throws IOException {
        for (String[] pokemon : pokemons){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new FileOutputStream("outputJson.json", true), pokemon);
        }
        System.out.println("Serialized JSON!");
    }

    static void writeApi(List<String[]> pokemons) throws IOException {
        for (String[] pokemon : pokemons){
            ObjectOutputStream out =  new ObjectOutputStream(
                    new FileOutputStream("outputApiPokemon.txt", true));
            out.writeObject(pokemon);
            out.close();
        }
        System.out.println("Serialized API!");
    }

    public static void main(String[] args) throws IOException, CsvException {
        Reader reader = Files.newBufferedReader(Paths.get("pokemons.csv"));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        List<String[]> pokemons = csvReader.readAll();

        writeApi(pokemons);
        writeJSON(pokemons);
        writeXML(pokemons);
    }
}
