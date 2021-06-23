package pe.edu.upc.producto.Cucumber;

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
import pe.edu.upc.producto.entities.Vehicle;
import pe.edu.upc.producto.repositories.VehicleRepository;
import pe.edu.upc.producto.services.VehicleService;
import pe.edu.upc.producto.services.impls.VehicleServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
public class MyStepdefs {
    private Long Id;
    @Autowired
    private VehicleService vehicleService;

    @MockBean
    private VehicleRepository vehicleRepository;

    @TestConfiguration
    static  class VehicleServiceImplTestConfiguration {
        @Bean
        public  VehicleService vehicleService() {return new VehicleServiceImpl();}

    }



    @Given("i have navigated to the page")
    public void iHaveNavigatedToThePage() {
    }

    @When("i find client by <clientId>")
    public void iFindClientByClientId(Long Id)throws Exception {
        //Arrange


        Vehicle vehicle = new Vehicle();
        vehicle.setId(Id);



        Mockito.when(vehicleRepository.findById(Id))
                .thenReturn(Optional.of(vehicle));

        //Act
        Optional<Vehicle> foundVehicle = vehicleService.findById(Id);

        // Assert

        assertThat(foundVehicle.get().getId()).isEqualTo(Id);

    }

    @Then("i see the object <id>")
    public void iSeeTheObjectId() {
    }
}
