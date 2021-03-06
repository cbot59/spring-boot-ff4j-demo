# Spring Boot FF4J Demo

Spring Boot FF4J Demo is a project used to be a poc (proof-of-concept) to implement a feature flag on [Klikpajak](https://my.klikpajak.id/) project with the help of [FF4J](https://github.com/ff4j/ff4j)

There are several use cases will be developed in order to pass the poc based on the requirements.

- [x] Simple feature toggle

- [x] Implement RBAC (Role Based Access Control)

- [x] Persist feature on MySQL

- [ ] Persist feature on Redis

- [ ] Implement cache

- [ ] Separate FF4j web and main application

- [ ] Implement AOP based check

- [ ] TBD

## Prerequisites

* Java 8

* Maven

## Running

Project are using [maven](https://maven.apache.org/) to run
```bash
mvnw spring-boot:run
```

## Testing

* FF4J web console

1. Open browser
2. Go to http://localhost:8080/ff4j-web-console/
3. Toggle any feature we would like to enable/disable

* Simple toggle

Request a `customer` feature as a `customer` user

```bash
curl -X GET --location "http://localhost:8080/api/customers" \
    -H "Accept: application/json" \
    -H "Authorization: Basic Y3VzdG9tZXI6Y3VzdG9tZXI="
```

* RBAC based toggle

Request a `seller` feature but authorized as a `customer` user

```bash
curl -X GET --location "http://localhost:8080/api/sellers" \
    -H "Accept: application/json" \
    -H "Authorization: Basic Y3VzdG9tZXI6Y3VzdG9tZXI="
```

## Preview

FF4J home

![FF4J home](https://i.ibb.co/HqMbtdr/ff4j-home.png)

FF4J feature page

![FF4J feature page](https://i.ibb.co/QcVmVTK/ff4j-feature-list.png)

Simple toggle ON

![Simple toggle ON](https://i.ibb.co/RpvgnmV/simple-toggle-on.png)

Simple toggle OFF

![Simple toggle OFF](https://i.ibb.co/t3MtDn0/simple-toggle-off.png)

RBAC based toggle

*Open seller API while logged in as customer

![RBAC based toggle](https://i.ibb.co/fDLd7tw/rbac-toggle.png)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
