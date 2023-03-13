package testCase;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.*;
/**
 * @program selenideTest
 * @description
 * @Author lixt@ttlee.com
 */
public class firstTest {

    //No need to manually download & configure & match webdriver
    //No need to init webdriver
    //No need to close & quit webdriver
    //implicit wait 隐式等待 & explicit wait 显式等待
    //自动对失败用例截图

    @BeforeMethod
    public void setUp() {
        Configuration.remote = "http://gridchrome-tdd-fd-zos-cg2.sis-frontend-testing-553e65d57aa996a84dfa67e2c277fee3-0000.us-south.containers.appdomain.cloud/wd/hub";

    }

    @Test
    public void testHomePage() {
        // 设置远程服务器（如selenium Grid Hub）
       // Configuration.remote = "http://35.78.202.67:4444/wd/hub";
    /*    Configuration.remote = "http://gridchrome-tdd-fd-zos-cg2.sis-frontend-testing-553e65d57aa996a84dfa67e2c277fee3-0000.us-south.containers.appdomain.cloud/wd/hub";
        Configuration.remoteConnectionTimeout = 60000;
        Configuration.browser = "chrome";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = chromeOptions;

     */
        open("https://okta.com");
    }

    @Test
    public void testBing() {
        open("https://bing.com");
        $("#sb_form_q")
                .shouldBe(editable)
                .setValue("Selenide");
        $("#sb_form_go")
                .shouldBe(enabled)
                .submit();
        $(".sb_count")
                .shouldBe(visible)
                .shouldHave(ownText("results"));
    }


}
