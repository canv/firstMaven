package lesson11.streams.reference.maven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lesson11.streams.reference.maven.Lesson11.fileAddress;

class CitiesReader {
    private List<String> cityNames;
    private List<String> citySectors;
    private List<String> sectorNames;
    private List<UUID> sectorIDs;
    private List<Integer> sectorLengths;
    private List<Integer> sectorWidths;

    void loader(Cites citesObj, String fileAddress) {
        try {
            List<String> fileContent =
                    new BufferedReader(new FileReader(fileAddress))
                            .lines()
                            .collect(Collectors.toList());

            separation(fileContent);
            distribution(citesObj);

        } catch (IOException exc) {
            System.out.println("File access error!");
        }
    }

    private void separation(List<String> fileContent){
        List<String> fileValues = fileContent.stream()
                .flatMap(s -> Stream.of(s.split(",")))
                .collect(Collectors.toList());

        cityNames = stringCollector(fileValues, "City:");
        citySectors = stringCollector(fileValues, "Class:");
        sectorNames = stringCollector(fileValues, "Name:");
        sectorIDs = idCollector(fileValues,"ID:");
        sectorLengths = intCollector(fileValues,"Length:");
        sectorWidths = intCollector(fileValues,"Width:");
    }
    private List<String> stringCollector(List<String> fileValues, String type) {
        return fileValues.stream()
                .filter(str -> str.startsWith(type))
                .map(str -> str.substring(str.indexOf(':') + 1))
                .collect(Collectors.toList());
    }
    private List<UUID> idCollector(List<String> fileValues, String type) {
        return fileValues.stream()
                .filter(str -> str.startsWith(type))
                .map(str -> str.substring(str.indexOf(':')+1))
                .map(UUID::fromString)
                .collect(Collectors.toList());
    }
    private List<Integer> intCollector(List<String> fileValues, String type) {
        return fileValues.stream()
                .filter(str -> str.startsWith(type))
                .map(str -> str.substring(str.indexOf(':')+1))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    private void distribution(Cites citesObj){
        for (int i = 0; i < cityNames.size(); i++) {
            addSector(
                    addCity(citesObj, cityNames.get(i)),
                    citySectors.get(i),
                    sectorNames.get(i),
                    sectorIDs.get(i),
                    sectorLengths.get(i),
                    sectorWidths.get(i)
            );
        }
    }
    private void addSector(City cityObj, String citySector, String sectorName,
                           UUID sectorID, int sectorLength, int sectorWidth) {
        switch (citySector) {
            case "Park":
                cityObj.addSector(new Park(sectorName,sectorID, sectorLength, sectorWidth));
                break;
            case "Street":
                cityObj.addSector(new Street(sectorName,sectorID, sectorLength, sectorWidth));
                break;
            case "District":
                cityObj.addSector(new District(sectorName,sectorID, sectorLength, sectorWidth));
                break;
            default:
                System.out.println("Sector not found!");
        }
    }
    private City addCity(Cites cites, String cityName) {
        if (cites.isHere(cityName))return cites.getCity(cityName);
        else cites.addCity(cityName,new City(cityName));
        return cites.getCity(cityName);
    }
}