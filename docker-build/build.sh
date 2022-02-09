#!/bin/sh

WEBAPPNAME=api-indonesia-1.0.1

echo "##### removing container docker $WEBAPPNAME"
docker rm --force $WEBAPPNAME

echo "##### removing images docker $WEBAPPNAME"
docker rmi --force muchanto/$WEBAPPNAME

echo "##### build docker $WEBAPPNAME"
docker build -t muchanto/$WEBAPPNAME . 

echo "##### save docker $WEBAPPNAME"
docker save -o muchanto.$WEBAPPNAME muchanto/$WEBAPPNAME

echo "##### removing docker saved image $WEBAPPNAME"
rm -rf muchanto.$WEBAPPNAME

echo "##### run docker $WEBAPPNAME"
docker run -d -p 8082:8082 --name=$WEBAPPNAME --restart=always --network="local-database_default" muchanto/$WEBAPPNAME 

echo "##### push to docker repository $WEBAPPNAME"
docker login && docker tag muchanto/$WEBAPPNAME muchanto/$WEBAPPNAME && docker push muchanto/$WEBAPPNAME