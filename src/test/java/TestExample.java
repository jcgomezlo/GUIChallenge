import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;


public class TestExample {
    private static final Logger Logger = LogManager.getLogger(TestExample.class);

   @Test
    public void test(){
       Logger.info("This is info debuf");
   }
}
