package lesson11.streams.reference.maven;

import static lesson11.streams.reference.maven.CityCalculation.*;

public class Lesson11 {
    public static void main(String[] args) {
// 1) Сделать получение всех данных для города из текстового файла на диске

        City city17 = new City();

        CityReader cityFile = new CityReader(fileAddress());
        cityFile.loader(city17);

        System.out.println("Total area of all city parks - " +
                totalSectorArea(city17.getCityParks()) +
                "\nTotal area of all city streets - " +
                totalSectorArea(city17.getCityStreets()) + "" +
                "\nTotal area of all living districts - " +
                totalSectorArea(city17.getCityDistricts()) +
                "\nTotal length of all streets - " +
                streetsLength(city17.getCityStreets()) +
                "\nTotal area of damaged roads - " +
                totalSectorDamageArea(city17.getCityParks()) +
                "\nTotal usable area of all coverage of the city - " +
                totalUsableArea(city17) + "\n");
    }

    static String fileAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\firstMaven\\src\\main\\java\\lesson11" +
                "\\streams\\reference\\maven\\city17.txt";
    }

    static String fileAddress2() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\firstMaven\\src\\main\\java\\lesson11" +
                "\\streams\\reference\\maven\\city18.txt";
    }
}