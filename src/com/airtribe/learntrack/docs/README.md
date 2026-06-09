LearnTrack — Project Flow

Overview

LearnTrack is a small Java project that models a simple learning/training system. The codebase uses packages under `com.airtribe.learntrack` and is organized into entity, service, ui, setup, util and docs modules. sources are under `src/`.

Key packages and responsibilities

- `com.airtribe.learntrack.entity`
  - Domain model classes: `Person`, `Student`, `Trainer`, `Course`, `Enrollment`.
  - These are plain Java objects (POJOs) that hold state for the application.

- `com.airtribe.learntrack.service`
  - Business logic services: `CourseService`, `StudentService`, `EnrollmentService`.
  - Services manage collections of entities in-memory and provide operations such as create, lookup and enroll.

- `com.airtribe.learntrack.ui`
  - `MainApplication` — entry point for the user-facing UI (text-based / example runner). It interacts with services to perform workflows.

- `com.airtribe.learntrack.setup`
  - `MainApp` — setup/initialization entry point for preparing sample data or running a setup routine.

- `com.airtribe.learntrack.util`
  - Utilities such as `IdGenerator` used across services to create unique IDs.

- `com.airtribe.learntrack.exception`
  - Custom exceptions (if present) used by services to signal error conditions (e.g., missing course or student).

- `docs/`
  - Supporting documentation such as `JVM_Basics.md` and `Setup_Instructions.md`.

Project flow (high level)

1. Application start
   - Run either `setup.MainApp` for setup routines or `ui.MainApplication` for the main UI/runner.

2. UI/Setup layer
   - The chosen main class initializes required services (`StudentService`, `CourseService`, `EnrollmentService`).
   - It may pre-populate sample data (courses, students) or prompt the user.

3. Service layer
   - Services hold in-memory collections of entities and provide operations. Example operations:
     - `StudentService` — create/find students.
     - `CourseService` — create/find courses.
     - `EnrollmentService` — enroll a student in a course, return enrollment status, list enrollments.
   - Services use `IdGenerator` to assign unique IDs to newly created entities.

4. Entity updates
   - When a user action triggers an operation (e.g., enroll), the service creates or updates `Enrollment` objects and associates them with `Student` and `Course` instances.

5. Result / Output
   - The UI displays results (success, error, enrollment status). There is no persistent storage by default — data is kept in memory for the duration of the run.

Example flow: Enrolling a student (logical steps)

- UI receives request: enroll student with id S1 into course with id C1.
- `EnrollmentService.enroll(S1, C1)`:
  - validate student exists via `StudentService`
  - validate course exists via `CourseService`
  - create `Enrollment` with a unique id from `IdGenerator`
  - set enrollment status (e.g., ENROLLED)
  - store the enrollment in the service's collection
  - return `Enrollment` object or status to UI

