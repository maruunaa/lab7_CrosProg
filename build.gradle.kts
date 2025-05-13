import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jetbrains.compose") version "1.5.10"
}

group = "net.strbasik"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)

    // Ktor client for API access (all dependencies must be same version)
    val ktorVersion = "2.3.2"
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    // JSON parsing (optional if you use kotlinx.serialization)
    implementation("com.google.code.gson:gson:2.8.9")

    // Material3 for Compose Desktop
    implementation("org.jetbrains.compose.material3:material3:1.3.0")

    implementation("androidx.compose.material3:material3:1.2.1")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "lab7"
            packageVersion = "1.0.0"
        }
    }
}

kotlin {
    jvmToolchain(17)
}
