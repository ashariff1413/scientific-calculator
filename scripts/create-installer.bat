@echo off
echo ========================================
echo Creating Full Installer
echo ========================================
echo.
echo This will create: ScientificCalculator-1.0.exe
echo (A professional installer with Start Menu and Desktop shortcuts)
echo.
echo NOTE: Requires WiX Toolset to be installed
echo Download from: https://wixtoolset.org/
echo.
pause

echo.
echo Building installer...
.\bin\jpackage.exe --input . --name "ScientificCalculator" --main-jar ScientificCalculator.jar --main-class Calculator --type exe --win-shortcut --win-menu --win-dir-chooser --app-version 1.0 --vendor "Scientific Calculator" --description "Advanced Scientific Calculator with Calculus" --icon calculator.ico

if errorlevel 1 (
    echo.
    echo ========================================
    echo ERROR: WiX Toolset not found!
    echo ========================================
    echo.
    echo Please install WiX Toolset:
    echo 1. Download from: https://wixtoolset.org/
    echo 2. Install and add to PATH
    echo 3. Restart this script
    echo.
    echo For now, use the portable version in:
    echo   ScientificCalculator\ScientificCalculator.exe
    echo.
    pause
    exit /b 1
)

echo.
echo ========================================
echo SUCCESS!
echo ========================================
echo.
echo Installer created: ScientificCalculator-1.0.exe
echo.
echo This installer will:
echo   - Install to Program Files
echo   - Create Start Menu shortcut
echo   - Create Desktop shortcut
echo   - Add uninstaller
echo.
echo Ready to distribute!
echo ========================================
pause
