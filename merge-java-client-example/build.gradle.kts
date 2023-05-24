plugins {
    id("application")
    id("merge.java")
    id("merge.kotlin")
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    implementation(project(":merge-java-client"))

    testImplementation(kotlin("test"))
    testImplementation(project(":merge-java-client-okhttp"))
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.33.2")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.assertj:assertj-guava:3.5.0")
    testImplementation("org.slf4j:slf4j-simple:1.7.29")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.1")
}

application {
    mainClass.set("dev.merge.example.Main")
}
