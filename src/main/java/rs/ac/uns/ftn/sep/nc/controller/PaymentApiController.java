package rs.ac.uns.ftn.sep.nc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.sep.nc.service.PaymentService;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentApiController {
    private final PaymentService paymentService;

}
