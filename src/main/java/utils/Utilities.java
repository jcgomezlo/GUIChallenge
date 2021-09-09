package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Iterables.isEmpty;

public class Utilities {
    private static final Logger Logger = LogManager.getLogger(Utilities.class);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");

    public static void captureScreenshot(WebDriver driver, String name){
        try {
            TakesScreenshot ss = (TakesScreenshot) driver;
            File src = ss.getScreenshotAs(OutputType.FILE);
            Allure.addAttachment(name, new ByteArrayInputStream(ss.getScreenshotAs(OutputType.BYTES)));
            FileHandler.copy(src, new File("./Screenshots/"+name+".png"));
            Logger.info("Screenshot taken");

        } catch (Exception e){
            Logger.info("Error taking screenshot");
        }
    }

    public static List<LocalDate> getDatesFromText(List<WebElement> elements){
        List<LocalDate> dates = new ArrayList<>();
        for(int i = 0;i<elements.size();i++){
            dates.add(LocalDate.parse(elements.get(i).getText(), formatter));
        }
        return dates;
    }

    public static boolean isSorted(List<LocalDate> data){
        if (isEmpty(data) || data.size() == 1) {
            return true;
        }

        Iterator<LocalDate> iter = data.iterator();
        LocalDate current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }


}
