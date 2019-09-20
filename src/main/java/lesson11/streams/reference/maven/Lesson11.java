package lesson11.streams.reference.maven;

import static lesson11.streams.reference.maven.CityCalculation.*;

public class Lesson11 {
    public static void main(String[] args) {
// 1) Сделать получение всех данных для города из текстового файла на диске
//      - прочитать данные из файла при прмощи ScreamAPI
//      - добавить зависимости apache, junit4, hamcrest, lombok
//      - написать тесты к проекту

        Cites cites = new Cites();

        CitiesReader citiesReader = new CitiesReader();
        citiesReader.loader(cites,fileAddress());

        System.out.println("Total area of all city parks - " +
                totalSectorArea(cites.getCity("Moscow").getCityParks()) +
                "\nTotal area of all city streets - " +
                totalSectorArea(cites.getCity("Moscow").getCityStreets()) + "" +
                "\nTotal area of all living districts - " +
                totalSectorArea(cites.getCity("Moscow").getCityDistricts()) +
                "\nTotal length of all streets - " +
                streetsLength(cites.getCity("Moscow").getCityStreets()) +
                "\nTotal usable area of all coverage of the city - " +
                totalUsableArea(cites.getCity("Moscow")) + "\n");

        System.out.println("Total area of all city parks - " +
                totalSectorArea(cites.getCity("Yaroslavl").getCityParks()) +
                "\nTotal area of all city streets - " +
                totalSectorArea(cites.getCity("Yaroslavl").getCityStreets()) + "" +
                "\nTotal area of all living districts - " +
                totalSectorArea(cites.getCity("Yaroslavl").getCityDistricts()) +
                "\nTotal length of all streets - " +
                streetsLength(cites.getCity("Yaroslavl").getCityStreets()) +
                "\nTotal usable area of all coverage of the city - " +
                totalUsableArea(cites.getCity("Yaroslavl")) + "\n");
    }

    static String fileAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\firstMaven\\src\\main\\java\\lesson11" +
                "\\streams\\reference\\maven\\citesFile.txt";
    }
}