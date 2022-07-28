package com.example.move

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify

class MoveApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Add this line, to include the Auth plugin.
        Amplify.addPlugin(AWSCognitoAuthPlugin())
        Amplify.configure(applicationContext)

        try {
            Amplify.configure(applicationContext)
            Log.i("MyAmplifyApp", "Initialized Amplify")
        } catch (error: AmplifyException) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error)
        }

    }

}