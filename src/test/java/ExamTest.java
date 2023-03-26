
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("ewstafiew")
public class ExamTest {

    @BeforeEach
    public void setup() {
        open("https://www.lamoda.ru/men-home/");
    }

    @Test
    @Story("Корзина")
    @DisplayName("Добавление товара в корзину")
    public void AddToCartProductTest() {

        step("Проскроллить экран главной до первой " +
                "карточки продукта", () -> {
            sleep(3000);
            TestPages.mainPages.mainProductCard()
                    .scrollTo();
        });

        step("Кликнуть по карточке товара на главной", () -> {
            TestPages.mainPages.mainProductCard()
                    .scrollTo();
        });

        step("Кликнуть по карточке товара на главной", () -> {
            TestPages.mainPages.mainProductCard()
                    .click();
        });

        step("Кликнуть на кнопку выбора размера", () -> {
            TestPages.modalProductPages.addToCardButton()
                    .click();
        });

        step("Выбрать первый размер в списке", () -> {
            TestPages.modalProductPages.selectSizeItem()
                    .click();
        });

        step("В окне отображается текст 'Товар добавлен в корзину'", () -> {
            TestPages.modalProductPages.modalHeader()
                    .shouldHave(text("Товар добавлен в корзину"));
        });


    }

    @MethodSource("searchByNameAndNumbers")
    @ParameterizedTest(name = "{displayName} {0}")
    @Story("Проверка поиска")
    @DisplayName("Проверка открытия страницы с поисковой выдачей")
    public void checkingTheReleaseSearchTest(String type, String searchValue) {

        step("Кликнуть на поисковую строку", () -> {
            TestPages.searchPages.searchBar()
                    .click();
        });

        step("Ввести в инпут поисковой запрос", () -> {
            TestPages.searchPages.searchBar()
                    .sendKeys(searchValue);
        });

        step("Нажать 'enter' на клавиатуре", () -> {
            TestPages.searchPages.searchBar()
                    .pressEnter();
        });

        step("В поисковой выдаче отображаются релизы " +
                "с искомым значением в названии", () -> {
            TestPages.searchPages.searchTextBlock()
                    .shouldHave(text(searchValue));
        });

    }


    static Stream<Arguments> searchByNameAndNumbers() {
        return Stream.of(
                arguments(
                        "Поисковой запрос по названию обуви",
                        "валенки"
                ),
                arguments(
                        "Поисковой запрос по букве",
                        "в"
                ),
                arguments(
                        "Поисковой запрос по цифрам",
                        "46"
                )
        );
    }


}
