@echo off
setlocal
set SCRIPT_DIR=%~dp0
set MAVEN_HOME=%SCRIPT_DIR%tools\apache-maven-3.9.16
set PATH=%MAVEN_HOME%\bin;%PATH%
mvn %*
endlocal
