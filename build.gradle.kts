// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.gradle.versions) apply  false
    alias(libs.plugins.version.catalog.update) apply false

}


tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}

