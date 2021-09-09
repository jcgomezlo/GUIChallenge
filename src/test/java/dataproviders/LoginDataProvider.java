package dataproviders;

import entities.LoginUtils;
import org.testng.annotations.DataProvider;
import utils.DataDeliver;

public class LoginDataProvider extends Hooks {
    @DataProvider(name = "ValidCredentials")
    public Object[][] ValidCredentials() {
        return new Object[][]{
                {LoginUtils.USER_ENV, LoginUtils.PASSWORD_ENV}
        };
    }

    @DataProvider(name = "InvalidCredentials")
    public Object[][] InvalidCredentials() {
        return DataDeliver.getInstance("data/data.xlsx").getData("InvalidCredentials");
    }
}
