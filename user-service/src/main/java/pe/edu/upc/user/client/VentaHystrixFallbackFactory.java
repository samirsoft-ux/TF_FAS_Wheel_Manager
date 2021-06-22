package pe.edu.upc.user.client;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.user.model.Offer;

public class VentaHystrixFallbackFactory implements VentaClient{
    @Override
    public ResponseEntity<Offer> getOffer(Long id) {
        Offer offer = Offer.builder()
                .offerName("none")
                .description("none")
                .imageUrl("none").build();
        return ResponseEntity.ok(offer);
    }
}
