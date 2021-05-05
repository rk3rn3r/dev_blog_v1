import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.eden.orchidPlugin") version "0.21.1"
    java
    kotlin("jvm") version "1.4.32"
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
    implementation(kotlin("stdlib"))
    implementation(project(":rk3futuretheme"))
    implementation("io.github.javaeden.orchid:OrchidCore:$orchid_version")
    orchidCompile("io.github.javaeden.orchid:OrchidCore:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidPosts:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidPages:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidWiki:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidNetlify:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidNetlifyCMS:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidPluginDocs:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidSearch:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidWritersBlocks:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidSyntaxHighlighter:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidTaxonomies:$orchid_version")
    orchidRuntime(project(":rk3futuretheme"))
    orchidRuntime("io.github.javaeden.orchid:OrchidAsciidoc:$orchid_version")

    // Use JUnit test framework
    //// testCompile("junit", "junit", "4.12")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
}

orchid {
    version = "${project.version}"
    theme = "RK3FutureTheme"
    destDir = "build/rk3rn3r/"
    baseUrl = "/"
}
