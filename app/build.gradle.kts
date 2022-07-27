plugins {
    kotlin("jvm") version "1.6.21"
    id("com.github.davidmc24.gradle.plugin.avro") version "1.3.0"
    application
}

group = "br.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    maven {
        url = uri("https://packages.confluent.io/maven/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("org.apache.kafka:kafka-clients:2.8.1")
    implementation("org.apache.avro:avro:1.11.0")
    implementation("io.confluent:kafka-avro-serializer:5.3.0")
    implementation("org.slf4j:slf4j-simple:1.7.36")
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<com.github.davidmc24.gradle.plugin.avro.GenerateAvroJavaTask> {
    source("src/main/resources/avro")
    setOutputDir(file("src/main/java/avro"))
}

application {
    mainClass.set("br.com.AppKt")
}
