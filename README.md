# To check how topic exchange works

# First way
* Run RabbitMQ in Docker container:
```ssh
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
```
* RabbitMQ web Console: http://localhost:15672/
* Run all three spring boot applications

# Second way
* Package each application with maven
* Build docker images with docker compose
```ssh
docker-compose build
```
* Run containers with docker compose
```ssh
docker-compose up
```
# Requests
* Messages will be published only to "myTopicQueue1" queue

![image](https://user-images.githubusercontent.com/84874469/197174089-9a4da8d0-0e87-4e7d-8fcd-f90746c295eb.png)
![image](https://user-images.githubusercontent.com/84874469/197174102-3ec0159a-d2f5-4aa3-8da5-4e4bc2a20bff.png)

* Messages will be published only to "myTopicQueue2" queue

![image](https://user-images.githubusercontent.com/84874469/197174136-dc1c09df-bc95-4d34-ab70-cecc5ddd2c57.png)
![image](https://user-images.githubusercontent.com/84874469/197174116-02ecbea1-5a9f-468b-bf16-4128eaaf3842.png)

![image](https://user-images.githubusercontent.com/84874469/197174168-6b2fa608-0fad-4f53-9408-c3394b4e7f04.png)
![image](https://user-images.githubusercontent.com/84874469/197174187-8680b4fe-b2e7-4809-97a4-878853d16ea3.png)

* Messages will be published to "myTopicQueue1" and "myTopicQueue2" queues

![image](https://user-images.githubusercontent.com/84874469/197174211-ffbf2c84-6ab4-4a85-9793-81194dc30eb9.png)
![image](https://user-images.githubusercontent.com/84874469/197174230-614f5496-9586-451f-8ab0-352724c9f951.png)

* Messages will be published only to "myTopicQueue3" queue

![image](https://user-images.githubusercontent.com/84874469/197174247-bdae3309-78c2-41bb-949a-e06c8c6b963c.png)
![image](https://user-images.githubusercontent.com/84874469/197174259-8fb132dc-f98e-4ab5-9e60-dfe22c8250af.png)
