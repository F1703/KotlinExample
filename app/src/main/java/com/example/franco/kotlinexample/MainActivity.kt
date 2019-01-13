package com.example.franco.kotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {



    private var editName: EditText?=null
    private var editAge: EditText?=null

    private var textName: TextView ?=null
    private var textAge: TextView?=null

    private var ejecutar: Button?=null

    private var name: String?=null
    private var age: String?=null

    private var radioM: RadioButton?=null
    private var radioF: RadioButton?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.editText_Name)
        editAge = findViewById(R.id.editText_Age) as EditText

        textName=findViewById(R.id.textView_Name) as TextView
        textAge=findViewById(R.id.textView_Age) as TextView

        ejecutar= findViewById(R.id.button_Ejecutar) as Button

        //invocar funciones a los editText
        editName!!.addTextChangedListener(this)
        editAge!!.addTextChangedListener(this)

        //invocar funciones para el button
        ejecutar!!.setOnClickListener(this)

        editName!!.inputType =InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

        radioM = findViewById(R.id.radioButton_M)
        radioF = findViewById(R.id.radioButton_F)

        radioM!!.setOnCheckedChangeListener(this)
        radioF!!.setOnCheckedChangeListener(this)

    }



    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //operacion()
        name = editName?.text.toString()
        if (name?.equals("") ?: (""===null)){
            editName!!.inputType =InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        }else{
            editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
        }
    }



    //button
    override fun onClick(v: View?) {
        operacion03()
    }


    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Toast.makeText(this,"Ha seleccionado una opcion",Toast.LENGTH_SHORT).show()
    }

    private fun operacion(){
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

    private  fun operacion02(){
        var cadena: String = ""         // var cadena = ""
        var entero: Int = 0             // var entero = 0
        var doble: Double= 0.0          // var doble  = 0.0
        var valor: Boolean = true       // var valor  = true
        var char: Char = 'k'            // var char   = 'k'
        var flo: Float = 5.2f           // var flo    = 5.2f

        val d = null?:4
    }

    private fun operacion03(){
        name = editName?.text.toString()
        age= editAge?.text.toString()

        if (name?.equals("") ?: (""===null)){
            editName!!.requestFocus()
        }else {
            textName?.text = name
            if (age?.equals("") ?: ("" ===null)){
                editAge!!.requestFocus()
            }else{
                textAge?.text =age
            }
        }
    }

}
