DOCKER_USERNAME ?= trade4life
APPLICATION_NAME ?= core

docker/build:
	docker build --tag ${DOCKER_USERNAME}/${APPLICATION_NAME} .

docker/run:
	docker run --name ${APPLICATION_NAME} -p8080:8080 ${DOCKER_USERNAME}/${APPLICATION_NAME}:latest
