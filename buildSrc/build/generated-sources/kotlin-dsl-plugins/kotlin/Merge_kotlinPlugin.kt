/**
 * Precompiled [merge.kotlin.gradle.kts][Merge_kotlin_gradle] script plugin.
 *
 * @see Merge_kotlin_gradle
 */
public
class Merge_kotlinPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Merge_kotlin_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
