#!/bin/bash
set -e
cd "$(dirname "$0")/.."
mkdir -p out
javac -d out $(find src/main/java -name "*.java")
java -cp out com.feasthub.app.FeastHubApp
