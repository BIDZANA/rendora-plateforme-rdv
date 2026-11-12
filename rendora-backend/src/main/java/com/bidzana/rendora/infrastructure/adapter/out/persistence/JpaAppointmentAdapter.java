package com.bidzana.rendora.infrastructure.adapter.out.persistence;
import com.bidzana.rendora.application.port.out.AppointmentRepositoryPort;
import com.bidzana.rendora.domain.Appointment;
import java.time.Instant;
import java.util.UUID;
import org.springframework.stereotype.Component;
@Component public class JpaAppointmentAdapter implements AppointmentRepositoryPort {
 private final SpringAppointmentRepository repository;
 public JpaAppointmentAdapter(SpringAppointmentRepository repository){this.repository=repository;}
 public boolean overlaps(UUID professionalId,Instant start,Instant end){return repository.existsOverlap(professionalId,start,end);}
 public Appointment save(Appointment a){repository.save(new AppointmentEntity(a.id(),a.professionalId(),a.clientId(),a.startsAt(),a.endsAt()));return a;}
}
