package com.bidzana.rendora.infrastructure.adapter.out.persistence;
import java.time.Instant;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
interface SpringAppointmentRepository extends JpaRepository<AppointmentEntity,UUID> {
 @Query("select count(a)>0 from AppointmentEntity a where a.professionalId=:professionalId and a.startsAt<:end and a.endsAt>:start")
 boolean existsOverlap(@Param("professionalId") UUID professionalId,@Param("start") Instant start,@Param("end") Instant end);
}
