package com.bidzana.rendora.infrastructure.adapter.out.persistence;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
@Entity @Table(name="appointments") public class AppointmentEntity {
 @Id UUID id; @Column(nullable=false) UUID professionalId; @Column(nullable=false) UUID clientId;
 @Column(nullable=false) Instant startsAt; @Column(nullable=false) Instant endsAt;
 protected AppointmentEntity(){}
 AppointmentEntity(UUID id,UUID professionalId,UUID clientId,Instant startsAt,Instant endsAt){this.id=id;this.professionalId=professionalId;this.clientId=clientId;this.startsAt=startsAt;this.endsAt=endsAt;}
}
