-- ═══════════════════════════════════════════
-- V1: Create users table
-- ═══════════════════════════════════════════

CREATE TABLE IF NOT EXISTS users (
    id              BIGSERIAL PRIMARY KEY,
    keycloak_id     VARCHAR(255) NOT NULL UNIQUE,
    email           VARCHAR(255) NOT NULL UNIQUE,
    display_name    VARCHAR(100),
    cefr_level      VARCHAR(2),         -- A1, A2, B1, B2, C1, C2
    learning_goal   VARCHAR(50),        -- EXAM_PREP, CAREER, HOBBY, TRAVEL
    target_exam     VARCHAR(20),        -- YDS, YOKDIL, IELTS
    yokdil_domain   VARCHAR(30),        -- FEN, SAGLIK, SOSYAL (only if YOKDIL)
    created_at      TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_users_keycloak_id ON users(keycloak_id);
CREATE INDEX idx_users_email ON users(email);

-- ═══ Trigger for updated_at ═══
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_users_updated_at
    BEFORE UPDATE ON users
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();
