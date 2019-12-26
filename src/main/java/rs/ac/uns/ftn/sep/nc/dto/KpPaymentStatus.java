package rs.ac.uns.ftn.sep.nc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KpPaymentStatus {
    private Long paymentId;
    private String status;
}
