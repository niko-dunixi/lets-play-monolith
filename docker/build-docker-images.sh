#!/usr/bin/env bash
set -e
cd ./grid-compose/
docker build -t wgu/selenium-base . -f selenium-base.dockerfile
docker build -t wgu/selenium-hub . -f selenium-hub.dockerfile
docker build -t wgu/selenium-node . -f selenium-node.dockerfile
docker build -t wgu/selenium-node-firefox . -f selenium-node-firefox.dockerfile
docker build -t wgu/selenium-node-chrome . -f selenium-node-chrome.dockerfile
