package rs.ac.uns.ftn.sep.nc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rs.ac.uns.ftn.sep.nc.dto.KpPaymentStatus;
import rs.ac.uns.ftn.sep.nc.dto.PaymentCompletedDto;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class RemoteKoncentratorPlacanja implements KoncentratorPlacanja {
    private static final String SERVICE_NAME = "kp";

    private final RestTemplate restTemplate;
    private final LoadBalancerClient loadBalancerClient;

    @Override
    public KpPaymentDto createPayment(CreateKpPaymentDto paymentDto) {
        URI uri = loadBalancerClient.choose(SERVICE_NAME).getUri();
        String requestUrl = uri.toString() + "api/payment";
        return restTemplate.postForEntity(requestUrl, paymentDto, KpPaymentDto.class).getBody();
    }

    @Override
    public boolean checkPaymentStatus(PaymentCompletedDto paymentCompletedDto) {
        URI uri = loadBalancerClient.choose(SERVICE_NAME).getUri();
        String requestUrl = uri.toString() + "api/payment/{paymentId}/status?token={token}";
        ResponseEntity<KpPaymentStatus> response = restTemplate
                .getForEntity(requestUrl, KpPaymentStatus.class, paymentCompletedDto.getPaymentId(), paymentCompletedDto.getToken());

        return response.getBody().getStatus().equalsIgnoreCase("success");
    }

}
