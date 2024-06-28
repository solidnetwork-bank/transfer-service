# transfer-service

# REMEMBER UPDATE VERSION
- pom.xml
- README
- commit
- tag


# Generate Jar before build
````
./.mvn/mvnw clean install
````

# build
````
docker build -t "solidnetworkxyz/transfer-service:1.0" .
````

# run
````
docker run --rm -it -p 80:80 solidnetworkxyz/transfer-service:1.0
````
# login
````
docker login -u solidnetworkxyz
````

# push
````
docker push solidnetworkxyz/transfer-service:1.0
````

