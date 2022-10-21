# To check how fanout exchange works

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

![img.png](img.png)
![img_1.png](img_1.png)

* Messages will be published only to "myTopicQueue2" queue

![img_3.png](img_3.png)
![img_2.png](img_2.png)

![img_9.png](img_9.png)
![img_8.png](img_8.png)

* Messages will be published to "myTopicQueue1" and "myTopicQueue2" queues

![img_5.png](img_5.png)
![img_4.png](img_4.png)

* Messages will be published only to "myTopicQueue3" queue

![img_6.png](img_6.png)
![img_7.png](img_7.png)