#!/usr/bin/env bash
set -e
# Stop and clean up old stuff before proceeding
time (docker-compose stop; docker-compose rm -f;)
# Pull up our docker lamp... Is this actually just damp?
time docker-compose up -d --build
