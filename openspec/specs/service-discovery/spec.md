## ADDED Requirements

### Requirement: Service Discovery via REST API

Feature: Service Discovery
  Rule: Client applications can query the registry to discover available service instances

#### Scenario: Query all instances for a known application
- **GIVEN** three instances of application `my-app` are registered
- **WHEN** a client sends a GET request to `/eureka/apps/my-app`
- **THEN** the registry responds with HTTP 200 OK
- **AND** the response contains all three registered instances with their metadata (hostname, port, status)

#### Scenario: Query unknown application returns empty response
- **GIVEN** no application named `unknown-app` has any registered instances
- **WHEN** a client sends a GET request to `/eureka/apps/unknown-app`
- **THEN** the registry responds with HTTP 404 Not Found

#### Scenario: Query all applications returns full registry
- **GIVEN** applications `app-a`, `app-b`, and `app-c` each have registered instances
- **WHEN** a client sends a GET request to `/eureka/apps`
- **THEN** the registry responds with HTTP 200 OK
- **AND** the response contains all applications and their instances

#### Scenario: Discovery response includes instance status
- **GIVEN** an instance of `my-app` is registered with status `UP`
- **WHEN** a client sends a GET request to `/eureka/apps/my-app`
- **THEN** the response includes the instance status as `UP`
