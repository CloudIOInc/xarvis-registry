## ADDED Requirements

### Requirement: Registry Web Dashboard

Feature: Registry Dashboard
  Rule: The registry provides a web-based dashboard for viewing registered applications and their status

#### Scenario: Dashboard displays all registered applications
- **GIVEN** applications `app-a` and `app-b` each have registered instances
- **WHEN** an operator navigates to the registry dashboard in a browser
- **THEN** the dashboard lists `app-a` and `app-b`
- **AND** each application entry shows the number of registered instances

#### Scenario: Dashboard shows instance-level details
- **GIVEN** `app-a` has two registered instances with metadata (hostname, port, status)
- **WHEN** an operator expands `app-a` on the dashboard
- **THEN** both instances are displayed with their hostname, port, and status

#### Scenario: Dashboard reflects instance eviction
- **GIVEN** an instance of `app-a` is evicted from the registry
- **WHEN** an operator views the dashboard
- **THEN** the evicted instance no longer appears under `app-a`
- **AND** the instance count for `app-a` is decremented

#### Scenario: Dashboard shows self-preservation status
- **GIVEN** the registry is in self-preservation mode
- **WHEN** an operator views the dashboard
- **THEN** the dashboard displays a self-preservation warning
