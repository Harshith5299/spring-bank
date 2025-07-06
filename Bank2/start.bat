@echo off
echo Stopping existing containers...
docker compose down
if errorlevel 1 (
    echo Failed to stop containers
    pause
    exit /b 1
)

echo Building with Maven...
call mvnw clean package -DskipTests
if errorlevel 1 (
    echo Maven build failed
    pause
    exit /b 1
)

echo Starting Docker containers...
docker compose up --build -d
if errorlevel 1 (
    echo Failed to start containers
    pause
    exit /b 1
)

echo Waiting for containers to initialize...
timeout /t 15 /nobreak

echo Checking container status...
docker compose ps
if errorlevel 1 (
    echo Container status check failed
    pause
    exit /b 1
)

echo Showing application logs...
docker compose logs -f app