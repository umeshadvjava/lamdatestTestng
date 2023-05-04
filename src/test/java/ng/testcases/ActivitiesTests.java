package ng.testcases;

import ng.utilities.Excelutils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ActivitiesTests extends TestBase{

    @Test(dataProvider ="data")
    public void displayName(String [] a){

        Arrays.asList(a).forEach(s-> System.out.println(s));

    }

    @DataProvider (name = "data")
    public Object[][] stringOfStrings() throws IOException {

        Object[][] arr = Excelutils.getData("E:\\Chintu\\Study\\Framework\\project\\lamdatestTestng\\src\\test\\resources\\testdata\\DataProvider1.xlsx","Sheet1");
        return arr;
    }
}
