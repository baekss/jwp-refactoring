FROM openjdk:11
ARG JAR_FILE=app-api/build/libs/*.jar
COPY ${JAR_FILE} webapp.jar
ENTRYPOINT ["java","-jar","/webapp.jar"]

# docker run -p 5000:8080 이미지_아이디명
# http://localhost:5000/api/products 일때 docker의 8080포트 어플로 연결

#docker exec -i -t 이미지명 /bin/bash
