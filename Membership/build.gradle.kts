buildscript {
    dependencies {
        classpath("io.spring.gradle:dependency-management-plugin:1.0.15.RELEASE")
    }
}

plugins {
    java
    `java-library`
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

group = "com.payserver.membership"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("com.tngtech.archunit:archunit:1.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    runtimeOnly("com.h2database:h2")
}

tasks.test {
    useJUnitPlatform()
}