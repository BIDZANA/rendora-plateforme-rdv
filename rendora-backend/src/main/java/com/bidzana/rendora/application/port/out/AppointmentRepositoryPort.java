package com.bidzana.rendora.application.port.out;
import com.bidzana.rendora.domain.Appointment;
import java.time.Instant;
import java.util.UUID;
public interface AppointmentRepositoryPort { boolean overlaps(UUID professionalId, Instant start, Instant end); Appointment save(Appointment appointment); }
