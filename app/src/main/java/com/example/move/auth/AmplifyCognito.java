package com.example.move.auth;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class AmplifyCognito {

    private Context context;

    public AmplifyCognito(Context context) {
        this.context = context;
    }


    public void signUp(String email, String username, String password){
        AuthSignUpOptions options = AuthSignUpOptions.builder()
                .userAttribute(AuthUserAttributeKey.email(), email)
                .userAttribute(AuthUserAttributeKey.name(),username)
                .build();

        Amplify.Auth.signUp(username, password, options,
                result -> {
                    Log.i("AuthQuickStart", "Result: " + result.toString());
                    //loadConfirm(username);
                },
                error -> Log.e("AuthQuickStart", "Sign up failed", error)
        );

    }



//    public void confirm (String username, String code){
//
//        Amplify.Auth.confirmSignUp(
//                username,
//                code,
//                result ->{ Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete");
//                    loadLogin();
//                },
//                error -> {Log.e("AuthQuickstart", error.toString());}
//        );
//
//    }



    public void signIn(String username, String password){
        Amplify.Auth.signIn(
                username,
                password,
                result -> Log.i("AuthQuickstart", result.isSignInComplete() ? "Sign in succeeded" : "Sign in not complete"),
                error -> Log.e("AuthQuickstart", error.toString())
        );

    }


    public void signOut(){
        Amplify.Auth.signOut(
                () -> Log.i("AuthQuickstart", "Signed out successfully"),
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }

//    private void loadConfirm(String username) {
//        Intent intent = new Intent(context, ConfirmActivity.class);
//        intent.putExtra("username",username);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }
//
//    private void loadLogin() {
//        Intent intent = new Intent(context, SignInActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }
}
