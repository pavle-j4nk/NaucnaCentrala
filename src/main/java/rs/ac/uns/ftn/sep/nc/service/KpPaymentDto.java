package rs.ac.uns.ftn.sep.nc.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KpPaymentDto {
    private Long paymentId;
    private String redirect;
}
