package dataproviders;

import entities.LoginUtils;
import org.testng.annotations.DataProvider;
import utils.DataDeliver;

public class FilterDataProvider extends Hooks {
    @DataProvider(name = "Genre")
    public Object[][] Genre() {
        return DataDeliver.getInstance("data/data.xlsx").getData("Genre");
    }

    @DataProvider(name = "Filter")
    public Object[][] Filter() {
        return DataDeliver.getInstance("data/data.xlsx").getData("Filter");
    }
}
