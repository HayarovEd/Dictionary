plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Rx-Java
    implementation ("io.reactivex.rxjava3:rxjava:3.1.3")
    implementation ("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.0")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    // Retrofit 2
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.12.1")
    implementation ("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

    //Room
    implementation ("androidx.room:room-common:2.4.2")
    kapt ("androidx.room:room-compiler:2.4.2")
    implementation ("androidx.room:room-ktx:2.4.2")


    implementation(project(mapOf("path" to ":model")))

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}