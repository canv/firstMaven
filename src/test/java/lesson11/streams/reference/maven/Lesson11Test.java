package lesson11.streams.reference.maven;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Lesson11Test {

    @Test
    public void isActualFileAddressTest(){
        File testFile = new File(CitiesReaderTest.testFileAddress());
        assertThat((testFile.isFile() && !testFile.isDirectory()),is(true));

        File file = new File(Lesson11.fileAddress());
        assertThat((file.isFile() && !file.isDirectory()),is(true));
    }
}