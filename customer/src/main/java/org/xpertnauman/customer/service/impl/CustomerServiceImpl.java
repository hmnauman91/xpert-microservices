package org.xpertnauman.customer.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xpertnauman.amqp.RabbitMQMessageProducer;
import org.xpertnauman.clients.fraud.FraudClient;
import org.xpertnauman.clients.fraud.response.FraudCheckResponse;
import org.xpertnauman.clients.notification.request.NotificationRequest;
import org.xpertnauman.customer.config.CustomerConfig;
import org.xpertnauman.customer.entity.Customer;
import org.xpertnauman.customer.model.request.CustomerRegistrationRequest;
import org.xpertnauman.customer.repository.CustomerRepository;
import org.xpertnauman.customer.service.CustomerService;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService
{
    private final CustomerConfig customerConfig;
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer messageProducer;

    @Transactional
    @Override
    public void registerCustomer(CustomerRegistrationRequest request)
    {

        if(!customerRepository.existsByEmail(request.email()))
        {
            final Customer customer = Customer.builder()
                    .firstName(request.firstName())
                    .lastName(request.lastName())
                    .email(request.email())
                    .build();

            //Todo check email is valid
            //Todo check email is not taken
            //Todo save customer in db
            Customer saved = customerRepository.saveAndFlush(customer);

            /*FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://fraud/v1/fraud/check/{customerId}",
                    FraudCheckResponse.class,
                    customer.getId());*/

            FraudCheckResponse fraudCheckResponse = fraudClient.checkIsFraudster(saved.getId());

            if(fraudCheckResponse != null && fraudCheckResponse.isFraudster())
                throw new IllegalStateException("fraudster");

            messageProducer.publish(NotificationRequest.builder()
                    .toCustomerId(saved.getId())
                    .toCustomerEmail(saved.getEmail())
                    .sender("xpertnauman")
                    .message(String.format("Hi %s you have registered successfully", saved.getFirstName()))
                    .build(),
                    customerConfig.getTopicExchangeName(),
                    customerConfig.getNotificationRoutingKey());

        }
        else
        {
            throw new IllegalStateException("Record already exists with email");
        }


    }
}
