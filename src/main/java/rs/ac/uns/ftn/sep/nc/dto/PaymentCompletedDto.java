package rs.ac.uns.ftn.sep.nc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCompletedDto {
    private Long paymentId;
    private String token;
}
