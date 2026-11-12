package com.bidzana.rendora.application.service;
import com.bidzana.rendora.application.port.out.AppointmentRepositoryPort;
import com.bidzana.rendora.domain.Appointment;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class BookAppointmentServiceTest {
 private final AppointmentRepositoryPort repository=mock(AppointmentRepositoryPort.class);
 private final BookAppointmentService service=new BookAppointmentService(repository);
 private final UUID professional=UUID.randomUUID(),client=UUID.randomUUID();
 private final Instant start=Instant.parse("2027-01-10T10:00:00Z"),end=Instant.parse("2027-01-10T10:30:00Z");
 @Test void rejectsOverlappingSlot(){when(repository.overlaps(professional,start,end)).thenReturn(true);assertThrows(SlotUnavailableException.class,()->service.book(professional,client,start,end));verify(repository,never()).save(any());}
 @Test void savesAvailableSlot(){when(repository.save(any())).thenAnswer(i->i.getArgument(0));Appointment a=service.book(professional,client,start,end);assertEquals(professional,a.professionalId());verify(repository).save(any());}
 @Test void rejectsInvalidInterval(){assertThrows(IllegalArgumentException.class,()->service.book(professional,client,end,start));verifyNoInteractions(repository);}
}
