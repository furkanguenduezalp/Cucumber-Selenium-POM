package com.vytrack.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

    public static List<String> getElementsText(List<WebElement> list){
        List<String> texts = new ArrayList<>();
        for (WebElement element : list) {
            texts.add(element.getText());
        }
        return texts;
    }

}
