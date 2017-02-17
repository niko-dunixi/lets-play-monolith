#!/usr/bin/env bash
set -e
echo "This is dangerous. You have to enable this script manually by commenting out exit."

# Comment this line out to enable.
# exit 1

for image in $(docker images -q);do
  docker rmi --force "${image}"
done
