package lesson11.streams.reference.maven;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CitiesReaderTest {

    static String testFileAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\firstMaven\\src\\main\\java\\lesson11" +
                "\\streams\\reference\\maven\\citesFileTest.txt";
    }

    @Test
    public void loaderFieldsTest() {

        try (BufferedReader bfCityReader = new BufferedReader
                (new FileReader(CitiesReaderTest.testFileAddress()))) {
            System.out.println("\tCity Reader's loader:");


            List<String> fileValues = bfCityReader.lines()
                    .flatMap(s -> Stream.of(s.split(",")))
                    .collect(Collectors.toList());

            List<String> cityNames = fileValues.stream()
                    .filter(str -> str.startsWith("City:"))
                    .map(str -> str.substring(str.indexOf(':') + 1))
                    .collect(Collectors.toList());
            assertThat(cityNames.size(),is(6));
            System.out.println("\ncitesSName:");
            for (String cityName : cityNames) System.out.println(cityName);

            List<String> citySectors = fileValues.stream()
                    .filter(str -> str.startsWith("Class:"))
                    .map(str -> str.substring(str.indexOf(':') + 1))
                    .collect(Collectors.toList());
            assertThat(citySectors.size(),is(6));
            System.out.println("\ncitSectors:");
            for (String citySector : citySectors) System.out.println(citySector);

            List<String> sectorNames = fileValues.stream()
                    .filter(str -> str.startsWith("Name:"))
                    .map(str -> str.substring(str.indexOf(':') + 1))
                    .collect(Collectors.toList());
            assertThat(sectorNames.size(),is(6));
            System.out.println("\nsectorsName:");
            for (String sectorName : sectorNames) System.out.println(sectorName);

            List<UUID> sectorIDs = fileValues.stream()
                    .filter(str -> str.startsWith("ID:"))
                    .map(str -> str.substring(str.indexOf(':') + 1))
                    .map(UUID::fromString)
                    .collect(Collectors.toList());
            assertThat(sectorIDs.size(),is(6));
            System.out.println("\nsectorsID:");
            for (UUID sectorID : sectorIDs) System.out.println(sectorID);

            List<Integer> sectorLengths = fileValues.stream()
                    .filter(str -> str.startsWith("Length:"))
                    .map(str -> str.substring(str.indexOf(':') + 1))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            assertThat(sectorLengths.size(),is(6));
            System.out.println("\nsectorsLength:");
            for (Integer sectorLength : sectorLengths) System.out.println(sectorLength);

            List<Integer> sectorWidths = fileValues.stream()
                    .filter(str -> str.startsWith("Width:"))
                    .map(str -> str.substring(str.indexOf(':') + 1))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            assertThat(sectorWidths.size(),is(6));
            System.out.println("\nsectorsWidth:");
            for (Integer sectorWidth : sectorWidths) System.out.println(sectorWidth);

        } catch (IOException exc) {
            System.out.println("File access error!");
        }
    }
}