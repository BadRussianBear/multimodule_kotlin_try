package com.example.fsm.ui.anotherForm

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.data.DataBase
import com.example.base.data.dao.GenderDao
import com.example.fsm.R
import com.example.fsm.ViewModelFactory
import com.example.fsm.databinding.AnotherMainBinding
import com.example.fsm.utils.toast
import dagger.android.AndroidInjection
import javax.inject.Inject


class AnotherActivity : AppCompatActivity() {

//    private lateinit var viewModel: AnotherActivityViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(AnotherActivityViewModel::class.java) }
    private val binding by lazy { DataBindingUtil.setContentView<AnotherMainBinding>(this, R.layout.another_main) }
    @Inject
    lateinit var dataBase: DataBase

    @Inject
    lateinit var genderDao: GenderDao

    override fun onCreate(savedInstanceState: Bundle?){
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setBindings()

        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.errorMessage.observe(this, {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
    }

    private fun setBindings(){
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun showError(@StringRes errorMessage:Int){
        toast(errorMessage.toString())
    }
    private fun hideError(){
        toast("All good")
    }
}
