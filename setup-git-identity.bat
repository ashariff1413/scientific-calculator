@echo off
echo ========================================
echo Git Identity Setup
echo ========================================
echo.
echo Git needs to know who you are for commits.
echo This is a ONE-TIME setup.
echo.
echo ========================================

set /p name="Enter your name (e.g., Abu Arfan): "
set /p email="Enter your email (e.g., abu@example.com): "

echo.
echo Setting up Git identity...
echo.

git config --global user.name "%name%"
git config --global user.email "%email%"

echo.
echo ========================================
echo Success!
echo ========================================
echo.
echo Your Git identity is now set to:
echo   Name: %name%
echo   Email: %email%
echo.
echo This will be used for all your Git commits.
echo.
echo Now you can run:
echo   git add .
echo   git commit -m "Initial commit"
echo.
pause
