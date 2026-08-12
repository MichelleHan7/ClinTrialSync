CREATE TABLE trials (
    id UUID PRIMARY KEY,
    trial_code VARCHAR(64) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    phase VARCHAR(32) NOT NULL,
    status VARCHAR(32) NOT NULL,
    start_date DATE NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_trials_status
    ON trials(status);
