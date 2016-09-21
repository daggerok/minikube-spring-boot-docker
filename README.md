minikube-spring-boot-docker [![build](https://travis-ci.org/daggerok/minikube-spring-boot-docker.svg?branch=master)](https://travis-ci.org/daggerok/minikube-spring-boot-docker)
===========================

```fish
mv gradle.properties.default gradle.properties
```

build latest image

```fish
gradle buildImage
... build
... createDockerfile
...
Successfully built 391404b408eb
Created image with ID '391404b408eb'.
# verify image
docker images  | grep 391404b40
daggerok/minikube-spring-boot-docker   latest   391404b408eb   29 seconds ago  660.9 MB
```

create container

```fish
gradle createContainer
:createContainer
Created container with ID 'c4d3b3f2dcf99d2751cb68b7cb7bd02b73323c2366c2ad182a627e802f1b9223'.
# verify container
docker ps -a | grep c4d3b3f2
c4d3b3f2dcf9        daggerok/minikube-spring-boot-docker:latest   "java -Djava.security"  33 seconds ago  Created  angry_mahavira
```

push image to hub.docker.com:

```fish
gradle push
...
:pushImage
Pushing image with name 'daggerok/minikube-spring-boot-docker:latest'.
# fetch image on kubernates pods:
gradle pullImage
Pulling repository 'daggerok/minikube-spring-boot-docker'.
```

## minikube

```fish
# install minikube

# start local cluster
minikune start
minikube dashboard

### on minikube UI page deploy new application from docker hub
# - app name:        minikube-boot-docker
# - container image: daggerok/minikube-spring-boot-docker:latest
# - number of pods:  2
# - service:         external, add ports 8080 and target port also 8080
# click deploy
# from console type
minikube service minikube-boot-docker --url # or
open (minikube service minikube-boot-docker --url)
# serf web page

## kubecrl also works
kubectl get service
kubectl get replicationcontrollers
# and so on...
```

clean

```fish
docker rmi -f daggerok/minikube-spring-boot-docker:latest
```


```sh
gradle clean build createDockerfile
# build image
docker build -t daggerok/minikube-spring-boot-docker:latest .
# run with console output
docker run -it --rm -p 8080:8080 --name minikube-spring-boot-docker daggerok/minikube-spring-boot-docker:latest
# or run as daemon:
docker run -d -p 8080:8080 --name minikube-spring-boot-docker daggerok/minikube-spring-boot-docker:latest
# clean
docker rmi -f daggerok/minikube-spring-boot-docker:latest
```
