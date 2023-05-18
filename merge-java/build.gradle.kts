plugins {
    id("merge.kotlin")
    id("merge.publish")
}

dependencies {
    api(project(":merge-java-client-okhttp"))
}

tasks.withType<Test> {
    exclude("**")
}
