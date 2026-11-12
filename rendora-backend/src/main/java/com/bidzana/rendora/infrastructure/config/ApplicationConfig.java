package com.bidzana.rendora.infrastructure.config;
import com.bidzana.rendora.application.port.in.BookAppointmentUseCase;
import com.bidzana.rendora.application.port.out.AppointmentRepositoryPort;
import com.bidzana.rendora.application.service.BookAppointmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration public class ApplicationConfig { @Bean BookAppointmentUseCase bookAppointmentUseCase(AppointmentRepositoryPort repository){return new BookAppointmentService(repository);} }
