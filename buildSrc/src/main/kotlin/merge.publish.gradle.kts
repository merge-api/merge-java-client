import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

plugins {
    `maven-publish`
    `signing`
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Merge File Storage API")
                description.set("The unified API for building rich integrations with multiple File Storage\nplatforms.")
                url.set("https://docs.merge.dev")

                licenses {
                    license {
                        name.set("custom")
                    }
                }

                developers {
                    developer {
                        name.set("Merge")
                        email.set("hello@merge.dev")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/merge-api/merge-java.git")
                    developerConnection.set("scm:git:git://github.com/merge-api/merge-java.git")
                    url.set("https://github.com/merge-api/merge-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")
    val signingKey = System.getenv("GPG_SIGNING_KEY")
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.publish {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
