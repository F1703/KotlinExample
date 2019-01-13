package com.example.franco.kotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {



    private var editName: EditText?=null
    private var editAge: EditText?=null

    private var textName: TextView ?=null
    private var textAge: TextView?=null

    private var ejecutar: Button ?=null

    private var name: String?=null
    private var age: String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.editText_Name) as EditText
        editAge = findViewById(R.id.editText_Age) as EditText

        textName=findViewById(R.id.textView_Name) as TextView
        textAge=findViewById(R.id.textView_Age) as TextView

        ejecutar= findViewById(R.id.button_Ejecutar) as Button

        //invocar funciones a los editText
        editName!!.addTextChangedListener(this)
        editAge!!.addTextChangedListener(this)

        //invocar funciones para el button
        ejecutar!!.setOnClickListener(this)
    }



    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //operacion()
    }



    //button
    override fun onClick(v: View?) {
        operacion()
    }

    fun operacion(){
        //Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show()

        // a las variables le asigno lo que obtengo de los EditText
        name=editName?.text.toString()
        age=editAge?.text.toString()

        //a los TextView le asigno lo que contiene las variables name y age
        //textName?.text = name.toString()
        //textAge?.text = age.toString()


        //validar los datos
        if (name !="") textName?.text = name
        if (age != "") textAge?.text = age
    }

}
