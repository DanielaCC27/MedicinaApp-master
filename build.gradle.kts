plugins {
    java
    // Plugin para Spring Boot, necesario para construir y ejecutar la aplicación.
    // Se utiliza la versión de Spring Boot 3.4.1
    id("org.springframework.boot") version "3.4.1"
    // Plugin para la gestión de dependencias en proyectos Spring.
    id("io.spring.dependency-management") version "1.1.7"
}



group = "co.edu.uniquindio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


java{
    toolchain{
        // Se define la versión de Java a utilizar (Java 22).
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

configurations {
    compileOnly {
        //  Asegura que los procesadores de anotaciones solo se incluyan en tiempo de compilación.
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    // Define Maven Central como el repositorio para las dependencias
    mavenCentral()
}


dependencies {

    // ==== Core Spring Boot ====
    // Starter Web de Spring Boot: Proporciona funcionalidades web básicas (REST, Tomcat embebido, JSON).
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Starter de validación: Anotaciones como @Email, @NotNull, etc.
    implementation("org.springframework.boot:spring-boot-starter-validation")
    // Starter de seguridad: Autenticación y autorización básica.
    implementation("org.springframework.boot:spring-boot-starter-security")


    // ==== JWT ====
    // Librería para generar y firmar tokens JWT (se combina con Spring Security).
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")


    // ==== Persistencia ====
    // Spring Boot JPA (para Hibernate y ORM).
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // Driver JDBC para Oracle (versión 21.x).TE MU
    implementation("com.oracle.database.jdbc:ojdbc11:23.2.0.0")

    // ==== Utilidades ====
    // Lombok: Reduce el código repetitivo (Getters, Setters, etc.).
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
    // Swagger / OpenAPI documentation
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")


    // MapStruct: Mapeo entre DTOs y entidades.
    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

    // ==== Testing ====
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-core")

}

tasks.test {
    useJUnitPlatform()
}