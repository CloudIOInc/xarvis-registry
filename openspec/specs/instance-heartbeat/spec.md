## ADDED Requirements

### Requirement: Instance Heartbeat Renewal

Feature: Instance Heartbeat
  Rule: Registered instances must periodically renew their lease to remain in the registry

#### Scenario: Instance sends heartbeat within expected interval
- **GIVEN** an instance with ID `instance-1` is registered under application `my-app`
- **WHEN** the instance sends a PUT request to `/eureka/apps/my-app/instance-1`
- **THEN** the registry responds with HTTP 200 OK
- **AND** the instance's lease renewal timestamp is updated

#### Scenario: Heartbeat for unknown instance is rejected
- **GIVEN** no instance with ID `unknown-instance` is registered under application `my-app`
- **WHEN** a PUT request is sent to `/eureka/apps/my-app/unknown-instance`
- **THEN** the registry responds with HTTP 404 Not Found

#### Scenario: Heartbeat with stale instance is rejected
- **GIVEN** an instance with ID `instance-1` was registered under application `my-app` but has been evicted
- **WHEN** a PUT request is sent to `/eureka/apps/my-app/instance-1`
- **THEN** the registry responds with HTTP 404 Not Found
