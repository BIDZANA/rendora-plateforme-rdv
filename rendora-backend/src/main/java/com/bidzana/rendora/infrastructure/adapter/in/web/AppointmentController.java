package com.bidzana.rendora.infrastructure.adapter.in.web;
import com.bidzana.rendora.application.port.in.BookAppointmentUseCase;
import com.bidzana.rendora.application.service.SlotUnavailableException;
import com.bidzana.rendora.domain.Appointment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.UUID;
@RestController @RequestMapping("/api/v1/appointments") public class AppointmentController {
 private final BookAppointmentUseCase book;
 public AppointmentController(BookAppointmentUseCase book){this.book=book;}
 public record BookingRequest(@NotNull UUID professionalId,@NotNull UUID clientId,@NotNull Instant startsAt,@NotNull Instant endsAt) {}
 @PostMapping public ResponseEntity<Appointment> create(@Valid @RequestBody BookingRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(book.book(request.professionalId(),request.clientId(),request.startsAt(),request.endsAt()));}
 @ExceptionHandler(SlotUnavailableException.class) ResponseEntity<String> conflict(SlotUnavailableException ex){return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());}
 @ExceptionHandler(IllegalArgumentException.class) ResponseEntity<String> invalid(IllegalArgumentException ex){return ResponseEntity.badRequest().body(ex.getMessage());}
}
