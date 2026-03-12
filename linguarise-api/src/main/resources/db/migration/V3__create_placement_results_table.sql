CREATE TABLE IF NOT EXISTS placement_test_results (
    id              BIGSERIAL PRIMARY KEY,
    user_id         BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    score           INT NOT NULL,
    total_questions INT NOT NULL,
    cefr_level      VARCHAR(2) NOT NULL,
    started_at      TIMESTAMP NOT NULL,
    completed_at    TIMESTAMP NOT NULL,
    answers_json    JSONB,
    created_at      TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_placement_results_user_id
    ON placement_test_results(user_id);

CREATE INDEX idx_placement_results_completed_at
    ON placement_test_results(completed_at DESC);