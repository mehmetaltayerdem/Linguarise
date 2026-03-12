-- ═══════════════════════════════════════════
-- V2: Create user_preferences table
-- ═══════════════════════════════════════════

CREATE TABLE IF NOT EXISTS user_preferences (
    id                      BIGSERIAL PRIMARY KEY,
    user_id                 BIGINT NOT NULL UNIQUE REFERENCES users(id) ON DELETE CASCADE,
    daily_word_goal         INT NOT NULL DEFAULT 5,
    daily_reading_goal      INT NOT NULL DEFAULT 1,
    daily_quiz_goal         INT NOT NULL DEFAULT 1,
    daily_review_goal       INT NOT NULL DEFAULT 10,
    interests               TEXT[],         -- Array of interest categories
    notification_enabled    BOOLEAN NOT NULL DEFAULT TRUE,
    created_at              TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at              TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_user_preferences_user_id ON user_preferences(user_id);

CREATE TRIGGER update_user_preferences_updated_at
    BEFORE UPDATE ON user_preferences
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();
