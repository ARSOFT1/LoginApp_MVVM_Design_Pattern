package com.arsoft.authenticate

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arsoft.authenticate.network.AuthApi
import com.arsoft.authenticate.network.RemoteDataSource
import com.arsoft.authenticate.repository.AuthRepository
import com.arsoft.authenticate.ui.AuthViewModel
import com.arsoft.authenticate.ui.base.ViewModelFactory
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val remoteDataSource = RemoteDataSource()
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = ViewModelFactory(AuthRepository(remoteDataSource.buildApi(AuthApi::class.java)))
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        viewModel.loginResponse.observe(this, Observer {
            Log.d("AuthLoginMvvm", it.data.toString())
        })

        val loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {
            val username = findViewById<TextInputEditText>(R.id.username)
            val password = findViewById<TextInputEditText>(R.id.password)
            viewModel.login(username.text.toString().trim(), password.text.toString().trim())
        }

    }
}