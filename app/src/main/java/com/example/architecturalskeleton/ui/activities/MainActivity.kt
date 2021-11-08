package com.example.architecturalskeleton.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecturalskeleton.R
import com.example.architecturalskeleton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewmodel.listObjectLiveData.observe(viewLifecycleOwner, EventObserver(
//            onError = {
//                snackbar(it)
//            },
//            onLoading = {
//                ic_progress.isVisible = true
//            }
//        ) { notes ->
//
//            ic_progress_notes.isVisible = false
//            todo set up your adapter
//
//        })
    }
}