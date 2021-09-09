package dataproviders;

import entities.LoginUtils;
import org.testng.annotations.DataProvider;
import utils.DataDeliver;

public class SearchDataProvider extends Hooks {
    @DataProvider(name = "Movies")
    public Object[][] Movies() {
        return DataDeliver.getInstance("data/data.xlsx").getData("Movies");
    }


}
