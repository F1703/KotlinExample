package com.example.franco.kotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var editName: EditText ?=null
    private var editAge: EditText?=null

    private var name: String?=null
    private var age: String?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.editText_Name) as EditText
        editAge = findViewById(R.id.editText_Age) as EditText
        



    }
}
