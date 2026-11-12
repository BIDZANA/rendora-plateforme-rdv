CREATE TABLE appointments (
 id UUID PRIMARY KEY,
 professional_id UUID NOT NULL,
 client_id UUID NOT NULL,
 starts_at TIMESTAMP WITH TIME ZONE NOT NULL,
 ends_at TIMESTAMP WITH TIME ZONE NOT NULL,
 CONSTRAINT chk_appointment_interval CHECK (starts_at < ends_at)
);
CREATE INDEX idx_appointments_professional_time ON appointments(professional_id, starts_at, ends_at);
-- Prevent concurrent overlapping appointments at database level (PostgreSQL):
CREATE EXTENSION IF NOT EXISTS btree_gist;
ALTER TABLE appointments ADD CONSTRAINT no_overlapping_appointments
 EXCLUDE USING gist (professional_id WITH =, tstzrange(starts_at, ends_at, '[)') WITH &&);
