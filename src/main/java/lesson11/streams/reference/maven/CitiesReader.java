package lesson11.streams.reference.maven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CitiesReader {
    void loader(Cites cityObj, String fileAddress) {
        try (BufferedReader bfCityReader = new BufferedReader
                (new FileReader(fileAddress))) {

            List<String> fileValues = bfCityReader.lines()
                    .flatMap(s -> Stream.of(s.split(",")))
                    .collect(Collectors.toList());

            List<String> cityNames = stringCollector(fileValues, "City:");
            List<String> citySectors = stringCollector(fileValues, "Class:");
            List<String> sectorNames = stringCollector(fileValues, "Name:");
            List<UUID> sectorIDs = idCollector(fileValues,"ID:");
            List<Integer> sectorLengths = intCollector(fileValues,"Length:");
            List<Integer> sectorWidths = intCollector(fileValues,"Width:");

            for (int i = 0; i < cityNames.size(); i++) {
                addSector(
                        addCity(cityObj, cityNames.get(i)),
                        citySectors.get(i),
                        sectorNames.get(i),
                        sectorIDs.get(i),
                        sectorLengths.get(i),
                        sectorWidths.get(i)
                );
            }

        } catch (IOException exc) {
            System.out.println("File access error!");
        }
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

    private City addCity(Cites cites, String cityName) {
        if (cites.isHere(cityName))return cites.getCity(cityName);
        else cites.addCity(cityName,new City(cityName));
        return cites.getCity(cityName);
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
}