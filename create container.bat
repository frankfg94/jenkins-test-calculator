docker image pull glassfish 
docker image ls
docker image rm ben-prj
docker build . -t ben-prj
docker stop devops-prj
docker container rm devops-prj
docker container create --publish 8082:8080 --name devops-prj ben-prj 
docker container start devops-prj
docker ps