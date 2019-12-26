package rs.ac.uns.ftn.sep.nc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePaymentResponseDto {
    private String redirectUrl;
}
