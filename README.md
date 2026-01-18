# Useful Commands #
## Run all tests ##
./gradlew test

## Run specific test ##
./gradlew :models:test --tests FormulaTest

## Run ConsoleApp ##
./gradlew :consoleApp:run

# Configuration #
## Git hook to run tests before commit ##
In .git/hooks/pre-commit:
#!/bin/sh
echo "Running tests..."
./gradlew test

if [ $? -ne 0 ]; then
  echo "Tests failed! Commit aborted."
  exit 1
fi