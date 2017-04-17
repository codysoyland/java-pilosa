
.PHONY: build clean generate-proto test test-all

build:
	mvn -f com.pilosa.client/pom.xml clean package

clean:
	mvn -f com.pilosa.client/pom.xml clean

generate-proto:
	protoc --java_out=com.pilosa.client/src/main/java/ com.pilosa.client/src/internal/public.proto

test:
	mvn -f com.pilosa.client/pom.xml test

test-all:
	mvn -f com.pilosa.client/pom.xml test failsafe:integration-test
