package com.example.nativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.nativetest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private ActivityMainBinding binding;
    private Float num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method

    }

    public void onClickAdd(View v){
        String input1 = binding.inputField1.getText().toString();
        String input2 = binding.InputField2.getText().toString();
        boolean check = !TextUtils.isEmpty(input1) && !TextUtils.isEmpty(input2)
                && TextUtils.isDigitsOnly(input1) && TextUtils.isDigitsOnly(input2);
        if(check) {
            num1 = Float.parseFloat(input1);
            num2 = Float.parseFloat(input2);
            binding.outputField.setText(String.valueOf(Add(num1, num2)));
        }
    }

    public void onClickSub(View v){
        String input1 = binding.inputField1.getText().toString();
        String input2 = binding.InputField2.getText().toString();
        boolean check = TextUtils.isDigitsOnly(input1) && TextUtils.isDigitsOnly(input2)
                && !TextUtils.isEmpty(input1) && !TextUtils.isEmpty(input2);
        if(check) {
            num1 = Float.parseFloat(input1);
            num2 = Float.parseFloat(input2);
            binding.outputField.setText(String.valueOf(Sub(num1, num2)));
        }
    }

    public void onClickMul(View v){
        String input1 = binding.inputField1.getText().toString();
        String input2 = binding.InputField2.getText().toString();
        boolean check = TextUtils.isDigitsOnly(input1) && TextUtils.isDigitsOnly(input2)
                && !TextUtils.isEmpty(input1) && !TextUtils.isEmpty(input2);
        if(check) {
            num1 = Float.parseFloat(input1);
            num2 = Float.parseFloat(input2);
            binding.outputField.setText(String.valueOf(Mul(num1, num2)));
        }
    }

    public void onClickDiv(View v){
        String input1 = binding.inputField1.getText().toString();
        String input2 = binding.InputField2.getText().toString();
        boolean check = TextUtils.isDigitsOnly(input1) && TextUtils.isDigitsOnly(input2)
                && !TextUtils.isEmpty(input1) && !TextUtils.isEmpty(input2);
        if(check) {
            num1 = Float.parseFloat(input1);
            int denominator = Integer.parseInt(input2);
            if(denominator != 0) {
                num2 = Float.parseFloat(input2);
                binding.outputField.setText(String.valueOf(Div(num1, num2)));
            }
            else {
                binding.outputField.setText("Can't divide by 0.");
            }
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native float Add(float num1, float num2);
    public native float Sub(float num1, float num2);
    public native float Div(float num1, float num2);
    public native float Mul(float num1, float num2);
}