rm:
	docker-compose rm --all -f

build:
	docker-compose build

up:
	docker-compose up

all: rm build up
