
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ExamTest {

    @BeforeEach
    public void setup() {
        open("https://www.lamoda.ru");
        Configuration.browserSize = "1280x720";
    }

    @Test
    @Story("Корзина")
    @DisplayName("Добавление в корзину состраницы товара")
    public void AddingСartProductPage() {

        step("Кликнуть на поисковую строку", () -> {
            TestPages.cardSearchPages.searchBar().click();
        });

        step("Ввести слово 'ватружка''", () -> {
            TestPages.cardSearchPages.searchBar().sendKeys("валенки");
        });

        step("Нажать кнопку 'Поиск'", () -> {
            TestPages.cardSearchPages.searchButton().click();
        });
        step("Кликнуть на карточку товара", () -> {
            TestPages.cardSearchPages.ProductCard().click();
        });
        step("Кликнуть на кнопку выбора размера", () -> {
            TestPages.cardSearchPages.sizeSelectionButton().click();
        });

    }

    @MethodSource("searchByNameAndNumbers")
    @ParameterizedTest(name = "{displayName} {0}")
    @Story("Проверка поиска")
    @DisplayName("Проверка открытия страницы с поисковой выдачей")
    public void checkingTheReleaseSearch(String type, String searchValue) {
        step("Нажать кнопку 'Поиск'", () -> {
            TestPages.cardSearchPages.searchButton().click();
        });

        step("Кликнуть на поисковую строку", () -> {
            TestPages.cardSearchPages.searchBar().click();
        });

        step("Ввести в инпут поисковой запрос", () -> {
            TestPages.cardSearchPages.searchBar().sendKeys(searchValue);
        });

        step("Нажать 'enter' на клавиатуре", () -> {
            TestPages.cardSearchPages.searchBar().pressEnter();
        });

        step("В поисковой выдаче отображаются релизы с искомым значением в названии", () -> {
            TestPages.cardSearchPages.ProductCard()
                    .shouldBe(visible);
        });
        sleep(4000);

    }


    static Stream<Arguments> searchByNameAndNumbers() {
        return Stream.of(
                arguments(
                        "Поисковой запрос по названию",
                        "валенки"
                ),
                arguments(
                        "Поисковой запрос по буквам",
                        "ботинки"
                ),
                arguments(
                        "Поисковой запрос по символам",
                        "123"
                )
        );
    }


}
