import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"

//    id("io.projectreactor.kotlin") version "1.0.2.RELEASE"      // didn't work

    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"

//    kotlin("io.projectreactor.kotlin") version "1.0.2.RELEASE"    // didn't work
}

group = "ghar.backend.kotlin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
//    implementation 'io.projectreactor.kotlin:reactor-kotlin-extensions:1.0.1.RELEASE'

    // ompile "io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.0-M1"
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
