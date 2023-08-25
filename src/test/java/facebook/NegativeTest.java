package facebook;

import org.example.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeTest {
    public static void main(String[] args) {
        // Путь к ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Открытие страницы Facebook
        driver.get("https://www.facebook.com/");

        // Ввод неверного пароля
        driver.findElement(By.id("email")).sendKeys("111@example.com");
        driver.findElement(By.id("pass")).sendKeys("неверный_пароль"); // Указываем неверный пароль
        driver.findElement(By.id("pass")).sendKeys(Keys.RETURN); // Нажатие клавиши Enter

        try {
            Thread.sleep(3000); // Пауза для ожидания загрузки страницы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверка наличия ошибки авторизации
        if (driver.getTitle().contains("Facebook")) {
            System.out.println("Авторизация (неверный пароль) неуспешна: Успешная авторизация!");
        } else {
            System.out.println("Авторизация (неверный пароль) успешна: Неуспешная авторизация!");
        }


        // Закрытие браузера
        driver.quit();
    }
}
