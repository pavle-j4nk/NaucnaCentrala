package rs.ac.uns.ftn.sep.nc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.sep.nc.dto.CreatePaymentRequestDto;
import rs.ac.uns.ftn.sep.nc.dto.CreatePaymentResponseDto;
import rs.ac.uns.ftn.sep.nc.dto.PaymentCompletedDto;
import rs.ac.uns.ftn.sep.nc.helper.ResponseEntityHelper;
import rs.ac.uns.ftn.sep.nc.service.PaymentService;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> createPayment(CreatePaymentRequestDto request) {
        CreatePaymentResponseDto payment = paymentService.createPayment(request);
        return ResponseEntityHelper.sendRedirect(payment.getRedirectUrl());
    }

    @GetMapping("completed")
    public ResponseEntity<?> paymentCompleted(PaymentCompletedDto paymentCompleted) {
        boolean status = paymentService.completedSuccessfully(paymentCompleted.getPaymentId(), paymentCompleted.getToken());

        String url = "/payment/" + (status ? "success" : "fail");
        return ResponseEntityHelper.sendRedirect(url);
    }

}
