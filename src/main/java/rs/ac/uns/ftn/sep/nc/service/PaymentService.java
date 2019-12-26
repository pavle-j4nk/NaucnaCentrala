package rs.ac.uns.ftn.sep.nc.service;

import rs.ac.uns.ftn.sep.nc.dto.CreatePaymentRequestDto;
import rs.ac.uns.ftn.sep.nc.dto.CreatePaymentResponseDto;

public interface PaymentService {

    CreatePaymentResponseDto createPayment(CreatePaymentRequestDto request);

    boolean completedSuccessfully(Long paymentId, String token);

}
