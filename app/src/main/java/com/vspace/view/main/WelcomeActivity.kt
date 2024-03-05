package com.vspace.view.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vspace.util.InjectionUtil
import com.vspace.view.list.ListViewModel

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("MissingSuperCall")
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        jump()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        previewInstalledAppList()
        jump()
    }

    private fun jump() {
        MainActivity.start(this)
        finish()
    }

    private fun previewInstalledAppList() {
        val viewModel = ViewModelProvider(this, InjectionUtil.getListFactory())[ListViewModel::class.java]
        viewModel.previewInstalledList()
    }
}
