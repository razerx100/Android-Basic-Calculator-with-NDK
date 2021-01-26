#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_nativetest_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jfloat JNICALL
Java_com_example_nativetest_MainActivity_Add(JNIEnv *env, jobject thiz, jfloat num1, jfloat num2) {
    return num1 + num2;
}
extern "C"
JNIEXPORT jfloat JNICALL
Java_com_example_nativetest_MainActivity_Sub(JNIEnv *env, jobject thiz, jfloat num1, jfloat num2) {
    return num1 - num2;
}
extern "C"
JNIEXPORT jfloat JNICALL
Java_com_example_nativetest_MainActivity_Mul(JNIEnv *env, jobject thiz, jfloat num1, jfloat num2) {
    return num1 * num2;
}
extern "C"
JNIEXPORT jfloat JNICALL
Java_com_example_nativetest_MainActivity_Div(JNIEnv *env, jobject thiz, jfloat num1, jfloat num2) {
    return num1 / num2;
}
