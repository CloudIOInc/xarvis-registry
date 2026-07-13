## ADDED Requirements

### Requirement: Automatic Eviction of Stale Instances

Feature: Instance Eviction
  Rule: Instances that fail to send heartbeats within the configured lease expiration interval are automatically removed from the registry

#### Scenario: Instance evicted after heartbeat timeout
- **GIVEN** an instance with ID `instance-1` is registered under application `my-app`
- **AND** the lease expiration duration is configured to 90 seconds
- **WHEN** no heartbeat is received for 90 seconds
- **THEN** the instance is removed from the registry
- **AND** a GET request to `/eureka/apps/my-app` does not include the evicted instance

#### Scenario: Instance not evicted when heartbeats arrive on time
- **GIVEN** an instance with ID `instance-1` is registered under application `my-app`
- **AND** the lease expiration duration is configured to 90 seconds
- **WHEN** the instance sends heartbeats every 30 seconds
- **THEN** the instance remains registered after 90 seconds

#### Scenario: Eviction count includes only stale instances
- **GIVEN** applications `app-a` and `app-b` each have one registered instance
- **AND** the `app-a` instance stops sending heartbeats
- **AND** the `app-b` instance continues sending heartbeats on time
- **WHEN** the eviction cycle runs
- **THEN** only the `app-a` instance is evicted
- **AND** the `app-b` instance remains registered
