plugins {
    id("buildlogic.kotlin-application-conventions")
}

dependencies {
    implementation(project(":models"))
}

application {
    mainClass = "com.nydev.app.ConsoleAppKt"
}
