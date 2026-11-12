package com.bidzana.rendora.application.service;
import com.bidzana.rendora.application.port.in.BookAppointmentUseCase;
import com.bidzana.rendora.application.port.out.AppointmentRepositoryPort;
import com.bidzana.rendora.domain.Appointment;
import java.time.Instant;
import java.util.UUID;
public class BookAppointmentService implements BookAppointmentUseCase {
 private final AppointmentRepositoryPort repository;
 public BookAppointmentService(AppointmentRepositoryPort repository){this.repository=repository;}
 public Appointment book(UUID professionalId, UUID clientId, Instant startsAt, Instant endsAt){
  Appointment appointment=new Appointment(UUID.randomUUID(),professionalId,clientId,startsAt,endsAt);
  if(repository.overlaps(professionalId,startsAt,endsAt)) throw new SlotUnavailableException();
  return repository.save(appointment);
 }
}
