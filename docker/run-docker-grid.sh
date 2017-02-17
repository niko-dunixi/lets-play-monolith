#!/usr/bin/env bash
set -e

#cd grid-compose

docker-compose up -d
# docker-compose scale node-firefox-debug=1
docker-compose scale node-chrome-debug=1
# docker-compose scale node-firefox=0
# docker-compose scale node-chrome=0

echo "------------------------------------------------"
echo "Go to http://localhost:4444/grid/console"
