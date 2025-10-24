@echo off
echo ========================================
echo Fixing Git Lock Error
echo ========================================
echo.

echo Checking for lock file...
if exist .git\index.lock (
    echo Found lock file! Deleting...
    del .git\index.lock
    echo Lock file deleted!
) else (
    echo No lock file found.
)

echo.
echo Checking for .git folder...
if exist .git (
    echo .git folder exists.
    echo You can now try your git commands again.
) else (
    echo No .git folder found.
    echo Run: git init
)

echo.
echo ========================================
echo Done!
echo ========================================
echo.
echo Try your git command again:
echo   git add .
echo   git commit -m "Initial commit"
echo.
pause
