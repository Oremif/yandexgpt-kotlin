@file:OptIn(ExperimentalWasmDsl::class)

import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.dokka.gradle.engine.parameters.VisibilityModifier
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dokka)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.oremif"
version = "0.1.0"

kotlin {
    explicitApi = ExplicitApiMode.Strict

    jvmToolchain(21)

    jvm()

    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget = JvmTarget.JVM_17
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    linuxX64()

    wasmJs {
        browser()
        nodejs()
        d8()
    }

    sourceSets {
        commonMain {
            dependencies {
                // Serialization
                api(libs.serialization.core)
                api(libs.serialization.json)

                // Coroutines
                api(libs.coroutines.core)

                // Ktor
                api(libs.ktor.client.core)
                api(libs.ktor.client.auth)
                api(libs.ktor.client.content.negotiation)
                api(libs.ktor.client.serialization.json)
                implementation(libs.ktor.client.logging)

                // Kotlinx
                implementation(libs.kotlinx.datetime)
            }
        }
        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "org.jetbrains.kotlinx.multiplatform.library.template"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

dokka {
    moduleName.set("YandexML-Kotlin-SDK")

    dokkaSourceSets.configureEach {
        sourceLink {
            localDirectory.set(file("src/main/kotlin"))
            remoteUrl("https://github.com/Oremif/YandexML-kotlin-sdk")
            remoteLineSuffix.set("#L")
            documentedVisibilities(VisibilityModifier.Public)
        }
    }
    dokkaPublications.html {
        outputDirectory.set(rootProject.layout.projectDirectory.dir("docs/dokka"))
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "library", version.toString())

    pom {
        name = "yandexml-kotlin-sdk"
        description = "Yandex Cloud ML Kotlin SDK"
        inceptionYear = "2025"
        url = "https://github.com/oremif/yandexml-kotlin-sdk/"
        licenses {
            license {
                name = "XXX"
                url = "YYY"
                distribution = "ZZZ"
            }
        }
        developers {
            developer {
                id = "devcrocod"
                name = "Pavel Gorgulov"
                url = "https://github.com/devcrocod"
            }
        }
        scm {
            url = "XXX" // TODO
            connection = "YYY"
            developerConnection = "ZZZ"
        }
    }
}
