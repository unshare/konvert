plugins {
    id("konvert.kotlin")
    id("konvert.mvn-publish")
    id("com.google.devtools.ksp").version("${Versions.kotlin}-${Versions.ksp}")
}


dependencies {
    api(project(":plugin-api"))
    api(project(":injectors:koin-annotations"))

    // auto service
    implementation("com.google.auto.service:auto-service-annotations:1.0.1")
    ksp("dev.zacsweers.autoservice:auto-service-ksp:1.0.0")

    testImplementation(project(":annotations"))
    testImplementation(project(":converter"))
    testImplementation(project(":processor"))
    testImplementation(testFixtures(project(":processor")))
    testImplementation(kotlinTest)
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.jUnit}")

}

tasks.test {
    useJUnitPlatform()
}
