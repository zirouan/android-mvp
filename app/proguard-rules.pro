# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Volumes/DevLiveo/DevLiveo/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep native methods
    -keepclassmembers class * {
        native <methods>;
    }

    -dontwarn okio.**
    -dontwarn com.squareup.okhttp.**
    -dontwarn javax.annotation.**
    -dontwarn com.android.volley.toolbox.**

    -ignorewarnings
    -keep class * {
        public private *;
    }
# Keep native methods

# Google
    -keep class android.support.v7.widget.** { *; }
    -dontwarn android.support.v4.**
    -keep public class android.support.v7.widget.** { *; }
    -keep public class android.support.v7.internal.widget.** { *; }
    -keep public class android.support.v7.internal.view.menu.** { *; }

    -keep public class * extends android.support.v4.view.ActionProvider {
        public <init>(android.content.Context);
    }
# Google

# Retrofit 2.X
    ## https://square.github.io/retrofit/ ##
    -dontwarn retrofit2.**
    -keep class retrofit2.** { *; }
    -keepattributes Signature
    -keepattributes Exceptions

    -keepclasseswithmembers class * {
        @retrofit2.http.* <methods>;
    }

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# Dagger
    # https://github.com/square/dagger
    -dontwarn dagger.internal.codegen.**
    -keepclassmembers,allowobfuscation class * {
        @javax.inject.* *;
        @dagger.* *;
        <init>();
    }

    -keep class dagger.* { *; }
    -keep class javax.inject.* { *; }
    -keep class * extends dagger.internal.Binding
    -keep class * extends dagger.internal.ModuleAdapter
    -keep class * extends dagger.internal.StaticInjection

# Fabric
    -keepattributes *Annotation*
    -keepattributes SourceFile,LineNumberTable
    -keep public class * extends java.lang.Exception
    -printmapping mapping.txt
# Fabric