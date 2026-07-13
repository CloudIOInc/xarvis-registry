## ADDED Requirements

### Requirement: Graceful Instance Deregistration

Feature: Instance Deregistration
  Rule: Instances can explicitly deregister from the registry on graceful shutdown

#### Scenario: Instance deregisters successfully
- **GIVEN** an instance with ID `instance-1` is registered under application `my-app`
- **WHEN** the instance sends a DELETE request to `/eureka/apps/my-app/instance-1`
- **THEN** the registry responds with HTTP 200 OK
- **AND** the instance is immediately removed from the registry
- **AND** a GET request to `/eureka/apps/my-app` does not include the deregistered instance

#### Scenario: Deregistration of unknown instance returns success
- **GIVEN** no instance with ID `unknown-instance` is registered under application `my-app`
- **WHEN** a DELETE request is sent to `/eureka/apps/my-app/unknown-instance`
- **THEN** the registry responds with HTTP 200 OK
