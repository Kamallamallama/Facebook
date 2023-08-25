package facebook;

import org.example.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeTest {
    public static void main(String[] args) {
        // Путь к ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Открытие страницы Facebook
        driver.get("https://www.facebook.com/");

        // Ввод неверного пароля
        driver.findElement(By.id("email")).sendKeys("email@example.com");
        driver.findElement(By.id("pass")).sendKeys("неверный_пароль"); // Указываем неверный пароль
        driver.findElement(By.id("pass")).sendKeys(Keys.RETURN); // Нажатие клавиши Enter

        try {
            Thread.sleep(3000); // Пауза для ожидания загрузки страницы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверка наличия ошибки авторизации
        if (driver.findElement(By.xpath("//div[contains(text(), 'The password that you')]")).isDisplayed()) {
            System.out.println("Неуспешная авторизация (негативный кейс): Неверный пароль!");
        } else {
            System.out.println("Неуспешная авторизация (негативный кейс): Ошибка при проверке неверного пароля!");
        }

        // Закрытие браузера
        driver.quit();
    }
}
