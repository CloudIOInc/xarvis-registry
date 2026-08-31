## ADDED Requirements

### Requirement: Self-Preservation Mode

Feature: Self-Preservation
  Rule: The registry suspends instance eviction during network partitions to prevent cascade failures

#### Scenario: Self-preservation activates when heartbeat threshold is breached
- **GIVEN** the registry is configured with a renewal threshold of 85%
- **AND** 20% of registered instances fail to send heartbeats within one renewal interval
- **WHEN** the eviction cycle runs
- **THEN** the registry enters self-preservation mode
- **AND** no instances are evicted
- **AND** the registry dashboard shows self-preservation as active

#### Scenario: Normal eviction resumes after heartbeat recovery
- **GIVEN** the registry is in self-preservation mode
- **WHEN** heartbeat traffic returns to above the renewal threshold for two consecutive intervals
- **THEN** the registry exits self-preservation mode
- **AND** eviction of genuinely stale instances resumes

#### Scenario: Self-preservation status is reported in registry response
- **GIVEN** the registry is in self-preservation mode
- **WHEN** a client sends a GET request to `/eureka/apps`
- **THEN** the response indicates self-preservation is enabled
