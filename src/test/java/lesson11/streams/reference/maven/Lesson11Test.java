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
    public void isItWork(){
        City city17 = new City();
        CityReader cityFile = new CityReader(Lesson11.fileAddress2());
        cityFile.loader(city17);



    }

}
