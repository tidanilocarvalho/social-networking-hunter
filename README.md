# social-networking-hunter
social-networking-hunter

* http://localhost:9090/social-networking-hunter/v2/api-docs
* http://localhost:9090/social-networking-hunter/swagger-ui.html

# Build and Run
* docker build -t danilo/social-networking-hunter .
* docker run -p 9090:9090 danilo/social-networking-hunter

* docker tag <IMAGE ID> tidanilocarvalho/social-networking-hunter:tag01
* docker push tidanilocarvalho/social-networking-hunter:tag01

# Latest Version
* docker pull tidanilocarvalho/social-networking-hunter:tag01
* docker run -p 9090:9090 tidanilocarvalho/social-networking-hunter:tag01

# New Versions
* docker tag <IMAGE ID> tidanilocarvalho/social-networking-hunter:<TAG ID>
* docker push tidanilocarvalho/social-networking-hunter:<TAG ID>

# Status
* http://localhost:9090/social-networking-hunter/actuator
* http://localhost:9090/social-networking-hunter/actuator/health
* http://localhost:9090/social-networking-hunter/actuator/health/liveness
* http://localhost:9090/social-networking-hunter/actuator/health/readiness
