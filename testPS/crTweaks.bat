@echo off
if not "%1"=="max" start /max cmd /c %0 max & Exit /b
chcp 65001 > nul

:::                                             ___        ___
:::                                            [ | ]      [ | ]   ┌───────┐   ╔════════════════════╗
:::                                            [=_=]      [=_=] ┌─│ ════ o│   ║                    ║
:::                                          ┌───┘          └───┘ ├───────┤   ║     Written by     ║       ╔═══════════════╗
:::                                          │ ╔══════════════╗   │[■■■■]o│   ║     Vero-sh        ║       ║ ≡ ▲ ▼ ■ ◄ ► o ║
:::                                          │ ║              ║   ├───────┤   ║                    ║       ║───────────────║   ___
:::                                          │ ║  Written by  ║   │       │   ╚════════╤══╤══════o═╝       ║▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒║  [ | ]
:::                                          │ ║  Vero-sh     ║   │       │─────┘  ____│__│____   │  ___   ║┌─────────────┐║  [=_=]
:::                                          █ ║              ║   │       │─┐     /____________\  │ [ | ]  ║└/───────────\┘║────┘
:::                                          │ ╚══════════════╝   └───────┘ │ ________________    │ [=_=]  ╚/_____________\╝
:::                                          └/::::::::::::::::\      │     └/::::::::::::::::\   └───┘
:::                                          /:::::════════:::::\    /T\    /:::::════════:::::\ 
:::                                          ════════════════════    \_/    ════════════════════

for /f "delims=: tokens=*" %%x in ('findstr /b ::: "%~f0"') do @echo(%%x
chcp 1252 > nul

:: === URL DEGLI SCRIPT ===
set "URL1=https://raw.githubusercontent.com/vero-sh/veroRepo/refs/heads/main/testPS/src/ crTweaks_source.ps1"
set "URL2=https://raw.githubusercontent.com/vero-sh/veroRepo/refs/heads/main/testPS/src/crTweaksFivem_source.ps1"

:: Menu
echo  ===========================
echo  Choose the script to execute:
echo  1) Debloat base
echo  2) Debloat only FiveM
echo  ---------------------------
echo.

choice /c 12 /n /m "Type 1 or 2 and press ENTER: "
if errorlevel 2 goto RUN2
if errorlevel 1 goto RUN1

:RUN1
echo.
echo [INFO] Downloading and executing Option 1 script...
for %%I in ("%TEMP%") do set "PSFILE=%%~sI\crTweaks_source.ps1"
powershell -NoProfile -ExecutionPolicy Bypass -Command ^
 "Invoke-WebRequest -Uri '%URL1%' -OutFile \"%PSFILE%\"; powershell -NoProfile -ExecutionPolicy Bypass -File \"%PSFILE%\""
goto END

:RUN2
echo.
echo [INFO] Downloading and executing Option 2 script...
for %%I in ("%TEMP%") do set "PSFILE=%%~sI\crTweaksFivem_source.ps1"
powershell -NoProfile -ExecutionPolicy Bypass -Command ^
 "Invoke-WebRequest -Uri '%URL2%' -OutFile \"%PSFILE%\"; powershell -NoProfile -ExecutionPolicy Bypass -File \"%PSFILE%\""
goto END

:END
echo.
echo. & echo ^> Press ANY key to exit . . . & pause > nul & exit