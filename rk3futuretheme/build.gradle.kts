import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    java
    kotlin("jvm") version "1.4.31"
}

project.group = rootProject.group
project.version = rootProject.version

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx")
    maven(url = "https://jitpack.io")
}

dependencies {
    val orchid_version = "0.21.1"
    implementation("io.github.javaeden.orchid:OrchidCore:$orchid_version")
    implementation(kotlin("stdlib"))

    testImplementation("io.github.javaeden.orchid:OrchidTest:$orchid_version")
//    testImplementation(Libs.hamcrest_library)
//    testImplementation(Libs.strikt_core)
//    testImplementation(Libs.mockito_core)
//    testImplementation(Libs.jsoup)
//    testImplementation(Libs.junit_jupiter_api)
//    testImplementation(Libs.junit_jupiter_params)
//    testRuntimeOnly(Libs.junit_jupiter_engine)
//    implementation(Libs.kotlin_stdlib_jdk8)

//    testCompile("junit", "junit", "4.12")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.jar {
    manifest {
        attributes(
            "Built-By" to System.getProperties().getProperty("user.name"),
            "Build-Timestamp" to SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(Date()),
            "Created-By" to "Gradle ${gradle.gradleVersion}",
            "Build-Jdk" to "${System.getProperties().getProperty("java.version")} (${System.getProperties().getProperty("java.vendor")} ${System.getProperties().getProperty("java.vm.version")})",
            "Build-OS" to "${System.getProperties().getProperty("os.name")} ${System.getProperties().getProperty("os.arch")} ${System.getProperties().getProperty("os.version")}",
            "Name" to project.name,
            "Plugin-Version" to project.version,
            "Bundle-License" to "LGPL-3.0",
            "Bundle-DocURL" to "https://rk3rn3r.dev"
        )
    }
}

