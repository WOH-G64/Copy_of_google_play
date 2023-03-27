package com.example.copy_of_google_play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.copy_of_google_play.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val parentAdapter = ParentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.parentRv.adapter = parentAdapter

        val data = mutableListOf<ParentItem>()

        repeat(10) {
            val childItems = mutableListOf<ChildItem>()
            repeat(10){ j ->
                childItems.add(ChildItem("Spotify ${j + 1}"))
            }
            data.add(ParentItem("Parent title: ${it + 1}", childItems))
        }

        parentAdapter.parentList.addAll(data)

    }
}