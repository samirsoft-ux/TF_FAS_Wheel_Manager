package pe.edu.upc.user.Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.user.entities.User;
import pe.edu.upc.user.repositories.UserRepository;
import pe.edu.upc.user.services.UserService;
import pe.edu.upc.user.services.impls.UserServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
public class MyStepdefs {


    private Long clientId;
    private String name;
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @TestConfiguration
    static  class UserServiceImplTestConfiguration {
        @Bean
        public  UserService userService() {return new UserServiceImpl();}

    }

    @Given("i have navigated to the page")
    public void iHaveNavigatedToThePage() {
    }


    @When("i find client by {long}")
    public void iFindClientByClientId(Long clientId) throws Exception {

        //Arrange


        User user = new User();
        user.setId(clientId);
        System.out.println(clientId);


        Mockito.when(userRepository.findById(clientId))
                .thenReturn(Optional.of(user));

        //Act
        Optional<User> foundUser = userService.findById(clientId);

        // Assert

        assertThat(foundUser.get().getId()).isEqualTo(clientId);

    }




    @Then("i see the object {long}")
    public void iSeeTheObjectId(Long id) {





    }
}
