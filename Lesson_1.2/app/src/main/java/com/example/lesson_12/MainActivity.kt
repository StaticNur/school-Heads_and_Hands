package com.example.lesson_12

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openLink()  //перейти по ссылке в браузер
        EmailMesseg()  //почта
        CallPhone()  //телефон
        openMapCoordinate()  //координаты
    }
    fun openLink(){
        val button_search:Button = findViewById(R.id.button_search)
        button_search.setOnClickListener{
            val edittext_browser = findViewById<EditText>(R.id.edittext_browser)
            try{
                val text = edittext_browser.text.toString()
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(text))
                startActivity(browserIntent)
            }catch (e:Exception){
                val invalid_link = findViewById<TextView>(R.id.invalid_link)
                invalid_link.setText("invalid link")
            }
        }
    }
    fun EmailMesseg(){
        val button_email:Button = findViewById(R.id.button_email)
        button_email.setOnClickListener{
            val edittext_email:EditText = findViewById(R.id.edittext_email)
            val email = edittext_email.text.toString()
            if((email == "") || (!email.contains("@"))){
                val invalid_email = findViewById<TextView>(R.id.invalid_email)
                invalid_email.setText("invalid email")
            }else{
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))  //Указываем получателя
                intent.putExtra(Intent.EXTRA_TEXT, "message")
                intent.type = "message/rfc822"
                startActivity(Intent.createChooser(intent, "Выберите email клиент :"))
            }
        }
    }
    fun CallPhone(){
        val button_phone:Button = findViewById(R.id.button_phone)
        button_phone.setOnClickListener{
            val edittext_phone = findViewById<EditText>(R.id.edittext_phone)
            val toDial = "tel:" + edittext_phone.text.toString()
            if ( (toDial == "tel:") || ((toDial.substring(5,toDial.length)).matches(Regex("^[a-zA-Z]*$")))  ){
                val invalid_phone_number = findViewById<TextView>(R.id.invalid_phone_number)
                invalid_phone_number.setText("invalid phone number")
            }else{
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(toDial)))
            }
        }
    }
    fun openMapCoordinate(){
        val button_map:Button = findViewById(R.id.button_map)
        button_map.setOnClickListener{
            val edittext_map = findViewById<EditText>(R.id.edittext_map)
            val coordinate = edittext_map.text.toString()
            if((coordinate == "") || (coordinate.matches(Regex("^[a-zA-Z]*$"))) ){
                val invalid_coordinate = findViewById<TextView>(R.id.invalid_coordinate)
                invalid_coordinate.setText("invalid coordinate")
            }else{
                val SHIROTA = coordinate.substring(0,7)
                val DOLGOTA = coordinate.substring(10,17)
                val intent = Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("https://geotree.ru/coordinates?lat="+SHIROTA+"&lon="+DOLGOTA+"&z=18&mlat="+SHIROTA+"&mlon="+DOLGOTA+"&c="+DOLGOTA+","+SHIROTA))
                startActivity(intent)
            }
        }
    }
}