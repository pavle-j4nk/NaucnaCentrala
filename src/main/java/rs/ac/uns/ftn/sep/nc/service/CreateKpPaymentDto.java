package rs.ac.uns.ftn.sep.nc.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateKpPaymentDto {
    private String merchant;
    private Double amount;
    private String redirectUrl;
}
