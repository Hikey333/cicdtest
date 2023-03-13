#Step 0: Choose base
FROM maven:latest

#Step 7: Copy our project
COPY . /app
#Making our working directory as /app
WORKDIR /app

CMD ["mvn test"]