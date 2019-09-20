package lesson11.streams.reference.maven;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CityTest {

    @Test
    public void addDamageStreetsFromTestFileTest(){

        Cites cites = new Cites();
        CitiesReader citiesReader = new CitiesReader();
        citiesReader.loader(cites,CitiesReaderTest.testFileAddress());

        //add to first value
        City.addDamage(cites.getCity("TestCity1").getCityStreets(),"TestStreet1",
                UUID.fromString("1aa111a1-a11a-1111-111a-a111aaa11111"),3,3);

        int calcDmg = CityCalculation.totalSectorDamageArea(cites.getCity("TestCity1").getCityStreets());
        assertThat(calcDmg,is(9));
    }

    @Test
    public void addDamageStreetsFromFileTest(){

        Cites cites = new Cites();
        CitiesReader citiesReader = new CitiesReader();
        citiesReader.loader(cites,Lesson11.fileAddress());

        //add to first value
        City.addDamage(cites.getCity("Moscow").getCityStreets(),"Lenina",
                UUID.fromString("feaa3027-cd1e-458f-9b33-ee0a1d9202c3"),5,5);

        int calcDmg = CityCalculation.totalSectorDamageArea(cites.getCity("Moscow").getCityStreets());
        assertThat(calcDmg,is(25));
    }

    @Test
    public void addDamageParksByHandsTest(){

        Cites middleEarth = new Cites();
        City rohan = new City("Rohan");
        rohan.addSector(new Park("Adoras",UUID.fromString("c32faf16-a4ba-4004-8479-bf6c6e59dbb0"),135,449));
        middleEarth.addCity("Rohan",rohan);

        City.addDamage(middleEarth.getCity("Rohan").getCityParks(),"Adoras",
                UUID.fromString("8a939cf2-a395-4e08-bf7e-070a22895b8e"),14,98);

        int calcDmg = CityCalculation.totalSectorDamageArea(middleEarth.getCity("Rohan").getCityParks());
        assertThat(calcDmg,is(1372));
    }
}
