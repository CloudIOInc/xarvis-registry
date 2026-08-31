## ADDED Requirements

### Requirement: Service Registration via REST API

Feature: Service Registration
  Rule: Services register with the Eureka registry through the standard REST endpoint

#### Scenario: Instance registers successfully
- **GIVEN** the registry is running
- **WHEN** a service instance sends a POST request to `/eureka/apps/{appName}` with valid instance metadata
- **THEN** the registry responds with HTTP 204 No Content
- **AND** the instance appears in the registry for its application name

#### Scenario: Instance registration with duplicated instance ID replaces the existing entry
- **GIVEN** an instance with ID `instance-1` is already registered under application `my-app`
- **WHEN** a POST request for the same `my-app` with instance ID `instance-1` is received with updated metadata
- **THEN** the registry responds with HTTP 204 No Content
- **AND** the existing instance entry is updated with the new metadata

#### Scenario: Registration with missing required fields is rejected
- **GIVEN** the registry is running
- **WHEN** a POST request to `/eureka/apps/{appName}` is sent without required metadata fields (e.g., hostname, port, or IP address)
- **THEN** the registry responds with HTTP 400 Bad Request
- **AND** the instance is not registered
