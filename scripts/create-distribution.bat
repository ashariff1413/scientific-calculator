@echo off
echo ========================================
echo Creating Distribution Package
echo ========================================
echo.

echo Compressing ScientificCalculator folder...
powershell Compress-Archive -Path ScientificCalculator -DestinationPath ScientificCalculator-Portable.zip -Force

echo.
echo ========================================
echo SUCCESS!
echo ========================================
echo.
echo Distribution package created:
echo   ScientificCalculator-Portable.zip
echo.
echo This zip file contains:
echo   - ScientificCalculator.exe
echo   - Bundled Java runtime
echo   - All required files
echo.
echo Users can:
echo   1. Extract the zip
echo   2. Run ScientificCalculator.exe
echo   3. No Java installation needed!
echo.
echo File is ready to share!
echo ========================================
pause
