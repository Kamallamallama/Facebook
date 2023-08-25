package facebook;

import org.example.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PositiveTest {
    public static void main(String[] args) {
        // Путь к ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        // Инициализация драйвера браузера
        WebDriver driver = new ChromeDriver();

        // Открытие страницы Facebook
        driver.get("https://www.facebook.com/");

        // Ввод логина и пароля
        driver.findElement(By.id("email")).sendKeys("email@example.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("pass")).sendKeys(Keys.RETURN); // Нажатие клавиши Enter

        try {
            Thread.sleep(3000); // Пауза для ожидания загрузки страницы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверка статуса авторизации
        if (driver.getTitle().contains("Facebook")) {
            System.out.println("Успешно");
        } else {
            System.out.println("Неуспешно");
        }

        // Закрытие браузера
        driver.quit();
    }
}
