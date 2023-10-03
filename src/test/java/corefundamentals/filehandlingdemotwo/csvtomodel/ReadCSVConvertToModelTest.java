package corefundamentals.filehandlingdemotwo.csvtomodel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sca820 on 18 nov., 2022
 */
class ReadCSVConvertToModelTest {

    static final String desktop = new File(System.getenv("HOMEPATH") + "/" + "Desktop").getAbsolutePath();

    @Test
    void generateModelList() {
        ReadCSVConvertToModel converter = new ReadCSVConvertToModel(desktop + "/FakeNames.CSV");
        List list = converter.generateModelList();
        list.forEach(System.out::println);
    }
}