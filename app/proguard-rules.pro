# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/user/Library/Android/sdk/tools/proguard/proguard-android.txt

# Keep Compose classes
-keep class androidx.compose.** { *; }

# Keep data classes
-keepclassmembers class com.example.microsaving.model.** {
    <fields>;
    <init>(...);
}
