package com.bidzana.rendora.application.port.in;
import com.bidzana.rendora.domain.Appointment;
import java.time.Instant;
import java.util.UUID;
public interface BookAppointmentUseCase { Appointment book(UUID professionalId, UUID clientId, Instant startsAt, Instant endsAt); }
