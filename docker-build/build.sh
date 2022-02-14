#!/bin/sh

WEBAPPNAME=api-indonesia

echo "##### stop docker container $WEBAPPNAME"
docker container stop $WEBAPPNAME

echo "##### removing docker container $WEBAPPNAME"
docker rm --force $WEBAPPNAME

echo "##### removing docker images $WEBAPPNAME"
docker rmi --force manto/$WEBAPPNAME

echo "##### build docker $WEBAPPNAME"
docker build -t manto/$WEBAPPNAME . 

# echo "##### save docker $WEBAPPNAME"
# docker save -o manto.$WEBAPPNAME manto/$WEBAPPNAME

# echo "##### removing docker saved image $WEBAPPNAME"
# rm -rf manto.$WEBAPPNAME

echo "##### run docker $WEBAPPNAME"
docker run -d --name=api-indonesia --restart=always --network=host manto/api-indonesia

# echo "##### push to docker repository $WEBAPPNAME"
# docker login && docker tag muchanto/$WEBAPPNAME muchanto/$WEBAPPNAME && docker push muchanto/$WEBAPPNAME