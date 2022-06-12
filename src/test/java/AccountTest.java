import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {

    @Parameterized.Parameter
    public String name;

    @Parameterized.Parameter(1)
    public boolean expectedResult;


    @Parameterized.Parameters(name = ": \"{0}\" | expectedResult = {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"E a", true},
                {"E  a", false},
                {"Ea", false},
                {"Ea ", false},
                {" Ea", false},
                {"Eva En Ru", false},
                {"Eva Featherstonehao", true},
                {"Eva Featherstonehapg", false},
                {null, false}
        };
    }

    @Step("Проверка соблюдения правил написания имени и фамилии: {account}")
    public void checkSubtractionStep(Account account) {
        Assert.assertEquals(expectedResult, account.checkNameToEmboss());
    }

    @Test
    public void checkName() {
        Account account = new Account(name);
        checkSubtractionStep(account);
    }
}