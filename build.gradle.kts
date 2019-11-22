import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("org.jlleitschuh.gradle.ktlint") version Versions.ktlintPlugin // "8.2.0"
}

ktlint {
    version.set(Versions.ktlint) // "0.34.2"
    debug.set(true)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    reporters.set(setOf(ReporterType.PLAIN, ReporterType.CHECKSTYLE))
    ignoreFailures.set(true)
    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

buildscript {
    /* no need configuration */
}

allprojects {
    /* no need configuration */
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}