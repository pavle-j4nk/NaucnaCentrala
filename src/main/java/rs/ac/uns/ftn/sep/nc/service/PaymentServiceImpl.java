package rs.ac.uns.ftn.sep.nc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import rs.ac.uns.ftn.sep.nc.dto.CreatePaymentRequestDto;
import rs.ac.uns.ftn.sep.nc.dto.CreatePaymentResponseDto;
import rs.ac.uns.ftn.sep.nc.dto.PaymentCompletedDto;
import rs.ac.uns.ftn.sep.nc.properties.NcProperties;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final KoncentratorPlacanja koncentratorPlacanja;
    private final NcProperties properties;

    @Override
    public CreatePaymentResponseDto createPayment(CreatePaymentRequestDto request) {
        CreateKpPaymentDto createKpPaymentDto = new CreateKpPaymentDto(request.getMerchant(), request.getAmount(), getPaymentProcessingUrl());
        KpPaymentDto payment = koncentratorPlacanja.createPayment(createKpPaymentDto);
        return new CreatePaymentResponseDto(payment.getRedirect());
    }

    @Override
    public boolean completedSuccessfully(Long paymentId, String token) {
        return koncentratorPlacanja.checkPaymentStatus(new PaymentCompletedDto(paymentId, token));
    }

    private String getPaymentProcessingUrl() {
        return UriComponentsBuilder.fromUriString(properties.getUrl()).pathSegment("payment").pathSegment("completed")
                .build().toString();
    }

}
