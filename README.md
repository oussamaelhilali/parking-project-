# Parking project

This repository contains the original parking example in `src/parking` and the SOLID version in `src/parking/refactored`.

## Run

Compile the Java files, then run:

```text
parking.Main
parking.refactored.Main
parking.refactored.ParkingServiceTest
```

The original and refactored programs print the same parking output. The test uses an in-memory log, so it does not create `parking.log`.

Written answers are in `docs/parking-answers.md`. The review table is in `docs/review-table.md`, and the refactored UML diagram is in `docs/parking-refactored-uml.svg`.
