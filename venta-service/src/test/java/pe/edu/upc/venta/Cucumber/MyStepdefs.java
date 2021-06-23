package pe.edu.upc.venta.Cucumber;

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
import pe.edu.upc.venta.entities.Offer;
import pe.edu.upc.venta.repositories.OfferRepository;
import pe.edu.upc.venta.services.OfferService;
import pe.edu.upc.venta.services.impls.OfferServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
public class MyStepdefs {

    private Long clientId;

    @Autowired
    private OfferService  offerService;

    @MockBean
    private OfferRepository offerRepository;

    @TestConfiguration
    static  class UserServiceImplTestConfiguration {
        @Bean
        public  OfferService offerService() {return new OfferServiceImpl();}

    }

    @Given("i have navigated to the page")
    public void iHaveNavigatedToThePage() {
    }

    @When("i find client by <clientId>")
    public void iFindClientByClientId(Long clientId) throws Exception{

        Offer offer= new Offer();
        offer.setId(clientId);

        Mockito.when(offerRepository.findById(clientId))
                .thenReturn(Optional.of(offer));

        //Act
        Optional<Offer> foundOffer = offerService.findById(clientId);

        // Assert

        assertThat(foundOffer.get().getId()).isEqualTo(clientId);
    }

    @Then("i see the object <id>")
    public void iSeeTheObjectId() {


    }
}
