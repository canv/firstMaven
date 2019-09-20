package lesson11.streams.reference.maven;

import org.junit.Test;
import java.util.UUID;

import static lesson11.streams.reference.maven.CityCalculation.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CityCalculationTest {

    private static UUID id1 = UUID.fromString("a11aaa11-a1aa-1111-1111-aa1a1a11aaa1");
    private static UUID id2 = UUID.fromString("a11aaa11-a1aa-1111-1111-aa1a1a11aaa2");
    private static UUID id3 = UUID.fromString("a11aaa11-a1aa-1111-1111-aa1a1a11aaa3");

    @Test
    public void totalSectorAreaParkTest(){
        Cites citesTest1 = new Cites();

        City testCity1 = new City("TesterCity1");
        testCity1.addSector(new Park("TesterPark1", id1,70,95));
        testCity1.addSector(new Park("TesterPark2", id2,6,55));
        testCity1.addSector(new Park("TesterPark3", id3,73,1));

        citesTest1.addCity("TesterCity1",testCity1);

        int result = totalSectorArea(citesTest1.getCity("TesterCity1").getCityParks());

        assertThat(result,is(7_053));
    }

    @Test
    public void totalSectorAreaStreetTest(){
        Cites citesTest2 = new Cites();

        City testCity2 = new City("TesterCity2");
        testCity2.addSector(new Street("TesterStreet1", id1,14,2));
        testCity2.addSector(new Street("TesterStreet2", id2,87,3));
        testCity2.addSector(new Street("TesterStreet3", id3,5,42));

        citesTest2.addCity("TesterCity2",testCity2);

        int result = totalSectorArea(citesTest2.getCity("TesterCity2").getCityStreets());

        assertThat(result,is(499));
    }

    @Test
    public void totalSectorAreaDistrictTest(){
        Cites citesTest3 = new Cites();
        City testCity3 = new City("TesterCity3");

        testCity3.addSector(new District("TesterDistrict1", id1,39,47));
        testCity3.addSector(new District("TesterDistrict2", id2,55,54));
        testCity3.addSector(new District("TesterDistrict3", id3,87,58));

        citesTest3.addCity("TesterCity3",testCity3);

        int result = totalSectorArea(citesTest3.getCity("TesterCity3").getCityDistricts());

        assertThat(result,is(9_849));
    }

    @Test
    public void districtTotalDamageAreaTest(){
        Cites citesTest4 = new Cites();
        City testCity4 = new City("TesterCity4");

        testCity4.addSector(new District("TesterDistrict1", id1,100,100));
        City.addDamage(testCity4.getCityDistricts(),"TesterDistrict1",
                id2,14,8);
        testCity4.addSector(new District("TesterDistrict2", id2,100,100));
        City.addDamage(testCity4.getCityDistricts(),"TesterDistrict2",
                id3,48,75);
        testCity4.addSector(new District("TesterDistrict3", id3,100,100));
        City.addDamage(testCity4.getCityDistricts(),"TesterDistrict3",
                id1,79,5);

        citesTest4.addCity("TesterCity4",testCity4);

        int result = totalSectorDamageArea(citesTest4.getCity("TesterCity4").getCityDistricts());

        assertThat(result,is(4_107));
    }

    @Test
    public void totalSectorsDamageAreaTest(){
        Cites citesTest5 = new Cites();
        City testCity5 = new City("TesterCity5");

        testCity5.addSector(new Street("TesterStreet", id1,100,100));
        City.addDamage(testCity5.getCityStreets(),"TesterStreet",
                id2,14,8);

        testCity5.addSector(new Park("TesterPark", id2,100,100));
        City.addDamage(testCity5.getCityParks(),"TesterPark",
                id3,48,75);

        testCity5.addSector(new District("TesterDistrict", id3,100,100));
        City.addDamage(testCity5.getCityDistricts(),"TesterDistrict",
                id1,79,5);

        citesTest5.addCity("TesterCity5",testCity5);

        int result = totalSectorDamageArea(citesTest5.getCity("TesterCity5").getCityStreets());
        result += totalSectorDamageArea(citesTest5.getCity("TesterCity5").getCityParks());
        result += totalSectorDamageArea(citesTest5.getCity("TesterCity5").getCityDistricts());

        assertThat(result,is(4_107));
    }

    @Test
    public void streetsLengthTest(){
        Cites citesTest2 = new Cites();

        City testCity2 = new City("TesterCity2");
        testCity2.addSector(new Street("TesterStreet1", id1,14,2));
        testCity2.addSector(new Street("TesterStreet2", id2,87,3));
        testCity2.addSector(new Street("TesterStreet3", id3,5,42));

        citesTest2.addCity("TesterCity2",testCity2);

        int result = streetsLength(citesTest2.getCity("TesterCity2").getCityStreets());

        assertThat(result,is(106));
    }
}