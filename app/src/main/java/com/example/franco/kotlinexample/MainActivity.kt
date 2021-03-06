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

    private var mensaje = ""
    private var genero = ""

    internal var lvsLista: ListView?=null  // otras clases tendran acceso a este objeto declarado como internal
    internal var nombre: Array<String>?=null
    internal var edad: Array<String>?=null
    internal var sexo: Array<String>?=null

    private var num = 10
    private  var count =1

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

        //radioM!!.setOnCheckedChangeListener(this)
        //radioF!!.setOnCheckedChangeListener(this)

        radioM!!.setOnClickListener(this)
        radioF!!.setOnClickListener(this)
        //depurar()

        lvsLista=findViewById(R.id.listView_lista)
        nombre= Array<String>(num,{""})
        edad= Array<String>(num,{""})
        sexo= Array<String>(num,{""})
        operacion04()
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
        //operacion03()
        when(v!!.id){ //id de tipo entero con !!
            //R.id.button_Ejecutar -> operacion03()
            R.id.button_Ejecutar -> operacion04()
            R.id.radioButton_M ->  Toast.makeText(this,"Ha seleccionado Masculino",Toast.LENGTH_SHORT).show()
            R.id.radioButton_F ->  Toast.makeText(this,"Ha seleccionado Femenino",Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView!!.id){
            R.id.radioButton_M -> if (isChecked) Toast.makeText(this,"Ha seleccionado Masculino",Toast.LENGTH_SHORT).show()
            R.id.radioButton_F -> if (isChecked) Toast.makeText(this,"Ha seleccionado Femenino",Toast.LENGTH_SHORT).show()
        }

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

    private fun depurar(){
        var valor = "Kotlin"

        when(valor){
            "Kotlin"-> mensaje = valor
            "Java"  -> mensaje = valor
        }
    }


    private fun operacion04(){
        name = editName?.text.toString()
        age= editAge?.text.toString()

        if (name?.equals("") ?: (""===null)){
            editName!!.requestFocus()
        }else {
            textName?.text = name
            if (age?.equals("") ?: ("" ===null)){
                editAge!!.requestFocus()
            }else{
                if (radioM!!.isChecked || radioF!!.isChecked){
                    var nombres: Array<String>
                    for(i in 0..num) // desde 0 hasta 10
                     {
                         if (nombre?.get(i).equals("")){
                             nombre?.set(i,name as String)
                             edad?.set(i,age as String)
                             sexo?.set(i,genero)
                             nombres= Array<String>(count,{""})
                             for (j in 0..i){
                                 nombres[j] = nombre?.get(j) as String
                             }
                             val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres)
                             lvsLista!!.adapter = adapter
                             count++
                             break
                         }
                     }

                }
            }
        }
    }

}
