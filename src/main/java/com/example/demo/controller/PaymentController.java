package com.example.demo.controller;

import com.example.demo.model.PaymentRequest;
import com.example.demo.services.CartService;
//import com.example.demo.services.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/payment")
public class PaymentController {

//    @Autowired
//    private PaymentService paymentService;

    @Autowired
    private CartService cartService;

    @Value("${app.test_key}")
    private String keytest;

//    @PostMapping("/create-session")
//    public ResponseEntity<Map<String, String>> createStripeSession(@RequestBody Map<String, Object> request) {
//        try {
//            // Initialize Stripe with the API key
//            Stripe.apiKey = keytest;
//
//
//            System.out.println("edlmwlemdl");
//            System.out.println("api"+keytest);
//            // Extract email and amount from the request
//            String email = (String) request.get("email");
//            double amount = (double) request.get("amount");
//
//            // Convert the amount to the smallest currency unit (e.g., cents for INR)
//            long amountInCents = Math.round(amount * 100);
//
//            // Create a new Stripe Checkout session
//            SessionCreateParams params = SessionCreateParams.builder()
//                    .setMode(SessionCreateParams.Mode.PAYMENT)
//                    .setCustomerEmail(email)
//                    .setSuccessUrl("http://localhost:5173/success") // Replace with your success URL
//                    .setCancelUrl("http://localhost:5173/cancel")   // Replace with your cancel URL
//                    .addLineItem(
//                            SessionCreateParams.LineItem.builder()
//                                    .setQuantity(1L)
//                                    .setPriceData(
//                                            SessionCreateParams.LineItem.PriceData.builder()
//                                                    .setCurrency("usd")
//                                                    .setUnitAmount(amountInCents)
//                                                    .setProductData(
//                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
//                                                                    .setName("Total Cart Amount")
//                                                                    .build()
//                                                    )
//                                                    .build()
//                                    )
//                                    .build()
//                    )
//                    .build();
//
//            // Create the session
//            Session session = Session.create(params);
//
//            // Return the session ID to the frontend
//            Map<String, String> response = new HashMap<>();
//            response.put("sessionId", session.getId());
//            System.out.println(response);
//
//            return ResponseEntity.ok(response);
//        } catch (StripeException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body(Map.of("error", "Payment session creation failed: " + e.getMessage()));
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            // Process the payment through Stripe
//            String paymentStatus = paymentService.processStripePayment(
//                    paymentRequest.getEmail(),
//                    paymentRequest.getAmount()
//            );
            if(paymentRequest.getAmount() > 0)
            {
                cartService.getItemsByEmail(paymentRequest.getEmail())
                        .forEach(cartItem -> cartService.removeCartItem(cartItem.getId()));
            }
            // Clear the cart if the payment is successful
//            if (paymentStatus.startsWith("Payment Successful")) {
//
//            }
             System.out.println("success");
            return ResponseEntity.ok("paymentStatus");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Payment failed: " + e.getMessage());
        }
    }
}
