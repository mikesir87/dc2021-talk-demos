#!/bin/sh

if [ "$API_HOST" != "" ]; then
  echo "Setting config.apiHost to $API_HOST"
  NEW_CONFIG=$(jq ".apiHost = \"$API_HOST\"" /usr/share/nginx/html/config.json)
  echo $NEW_CONFIG > /usr/share/nginx/html/config.json
fi

exec /docker-entrypoint.sh "$@"