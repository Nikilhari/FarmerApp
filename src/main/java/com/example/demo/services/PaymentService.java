//package com.example.demo.services;
//
//import com.example.demo.model.Payment;
//import com.example.demo.repository.PaymentRepo;
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.PaymentIntent;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class PaymentService {
//
//    @Autowired
//    private PaymentRepo paymentRepo;
//    @Value("${app.test_key}")
//    private String keytest;
//    @PostConstruct
//    public void init() {
//        Stripe.apiKey = keytest;
//    }
//
//    public String processStripePayment(String email, double amount) {
//        try {
//            // Convert the amount to cents as Stripe expects the smallest currency unit
//            long amountInCents = Math.round(amount * 100);
//
//            // Create PaymentIntent
//            Map<String, Object> params = new HashMap<>();
//            params.put("amount", amountInCents);
//            params.put("currency", "inr");
//            params.put("payment_method", paymentMethodId);
//            params.put("confirmation_method", "manual");
//            params.put("confirm", true);
//
//            PaymentIntent paymentIntent = PaymentIntent.create(params);
//
//            if ("succeeded".equals(paymentIntent.getStatus())) {
//                // Save successful payment details to the database
//                Payment payment = new Payment();
//                payment.setEmail(email);
//                payment.setAmount(amount);
//                payment.setPaymentMethod(paymentMethodId);
//                payment.setPaymentStatus("Success");
//                payment.setCreatedAt(java.time.LocalDateTime.now());
//
//                paymentRepo.save(payment);
//
//                return "Payment Successful for " + email;
//            } else {
//                return "Payment failed: " + paymentIntent.getStatus();
//            }
//        } catch (StripeException e) {
//            e.printStackTrace();
//            return "Payment failed: " + e.getMessage();
//        }
//    }
//}
