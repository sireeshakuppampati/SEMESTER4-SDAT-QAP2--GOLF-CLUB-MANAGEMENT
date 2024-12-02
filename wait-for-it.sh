#!/usr/bin/env bash

host=$1
port=$2
shift 2

# Wait until the service at host:port is available
while ! nc -z $host $port; do
  echo "Waiting for $host:$port to be available..."
  sleep 1
done

# Execute the command after the service becomes available
exec "$@"
