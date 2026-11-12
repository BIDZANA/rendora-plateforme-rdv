package com.bidzana.rendora.domain;
import java.time.Instant;
import java.util.UUID;
public record Appointment(UUID id, UUID professionalId, UUID clientId, Instant startsAt, Instant endsAt) {
 public Appointment { if(id==null||professionalId==null||clientId==null||startsAt==null||endsAt==null) throw new IllegalArgumentException("Missing appointment fields"); if(!startsAt.isBefore(endsAt)) throw new IllegalArgumentException("End must be after start"); }
}
