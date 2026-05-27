$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$env:MAVEN_HOME = Join-Path $scriptDir 'tools\apache-maven-3.9.16'
$env:PATH = "$env:MAVEN_HOME\bin;$env:PATH"
& mvn @args
