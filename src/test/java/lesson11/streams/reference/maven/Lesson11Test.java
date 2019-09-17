package lesson11.streams.reference.maven;

import org.junit.Test;

import java.io.File;

import static lesson11.streams.reference.maven.City.addDamage;
import static lesson11.streams.reference.maven.CityCalculation.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Lesson11Test {

    @Test
    public void isActualFileAddressTest(){
        File file = new File(Lesson11.fileAddress());
        assertThat((file.isFile() && !file.isDirectory()),is(true));

    }

    @Test
    public void nonFileBuildTest(){
        City city17 = new City();

        city17.addSector(new Park("May", 123, 221));
        addDamage(city17.getParks(), "May", 5, 2);

        city17.addSector(new Street("Cosmonauts", 3234, 700));
        addDamage(city17.getStreets(), "Cosmonauts", 2034, 56);

        city17.addSector(new LivingDistrict("GGR7", 664, 600));
        addDamage(city17.getLivingDistricts(), "GGR7", 3, 77);
        addDamage(city17.getLivingDistricts(), "GGR7", 34, 43);

        assertThat(totalSectorArea(city17.getParks()),is(27183));
        assertThat(totalSectorArea(city17.getStreets()),is(2263800));
        assertThat(totalSectorArea(city17.getLivingDistricts()),is(398400));
        assertThat(streetsLength(city17.getStreets()),is(3234));
        assertThat(totalSectorDamageArea(city17.getParks()),is(10));
        assertThat(totalUsableArea(city17),is(2573776));
    }
}
