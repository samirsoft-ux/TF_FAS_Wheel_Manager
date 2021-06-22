package pe.edu.upc.producto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.producto.model.Offer;

@FeignClient(name = "venta-service", fallback = VentaHystrixFallbackFactory.class)
//@RequestMapping(value = "/ventas")
public interface VentaClient {

    @GetMapping(value = "/ventas/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable("id") Long id);
}
