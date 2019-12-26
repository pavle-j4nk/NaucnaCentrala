package rs.ac.uns.ftn.sep.nc.service;

import rs.ac.uns.ftn.sep.nc.dto.PaymentCompletedDto;

public interface KoncentratorPlacanja {

    KpPaymentDto createPayment(CreateKpPaymentDto paymentDto);

    boolean checkPaymentStatus(PaymentCompletedDto paymentDto);

}
