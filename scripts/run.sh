#!/bin/bash
# This file is a generic template created with each new repository. Edit as needed to match applicaiton speciffic configuration.

# Load environment variables 
source /app/bin/env.sh

# Start application
java --enable-preview ${JAVA_OPTS} -jar /app/active/${PROJECT}.jar