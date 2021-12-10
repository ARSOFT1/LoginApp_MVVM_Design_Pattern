package com.arsoft.authenticate.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arsoft.authenticate.repository.AuthRepository
import com.arsoft.authenticate.repository.BaseRepository
import com.arsoft.authenticate.ui.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: AuthRepository):ViewModelProvider.NewInstanceFactory()  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModel Class Not Fuond")

        }
    }
}