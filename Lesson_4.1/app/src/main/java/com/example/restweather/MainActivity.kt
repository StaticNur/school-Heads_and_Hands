package com.example.restweather

import com.android.volley.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.restweather.databinding.ActivityMainBinding
import org.json.JSONObject


const val API_KEY = "9bb1159de971c047caddaa4b08f9b404"//"a51b5d142b02b40349d7368498b021a4"
class MainActivity : AppCompatActivity()
{
    private final val TAG = MainActivity::class.java.toString()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener{
            GetResult(binding.etText.text.toString())//"Moscow")
        }
    }
    private fun GetResult(name:String){
        val arr_name = name.split(" ")
        lateinit var url:String
        try{
            if (isNumber(name))
                url = "https://api.openweathermap.org/data/2.5/weather?id=$name&appid=$API_KEY&units=metric"//индекс города
            else if(isNumber(arr_name[0]) && !isNumber(arr_name[1]))
                url = "https://api.openweathermap.org/data/2.5/weather?zip=${arr_name[0]},${arr_name[1]}&appid=$API_KEY&units=metric"//почтовый индекс: 430005 ru
            else if(isNumber(arr_name[0]) && isNumber(arr_name[1]))
                url = "https://api.openweathermap.org/data/2.5/weather?lat=${arr_name[1]}&lon=${arr_name[0]}5&appid=$API_KEY&units=metric"// lon lat координа: 45.1749 54.1838
            else if(!isNumber(name))
                url = "https://api.openweathermap.org/data/2.5/weather?q=$name&appid=$API_KEY&units=metric"//город
        }catch (e:Exception){
            print(e)
        }

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                response->
                val obj = JSONObject(response)

                binding.tvName.text = "name: "+obj.getString("name")

                val coord = obj.getJSONObject("coord")
                binding.tvCoord.text = "lon: "+coord.getString("lon")+"\n"+"lat:  "+coord.getString("lat")

                val temp = obj.getJSONObject("main")
                binding.tvTemp.text = temp.getString("temp")+"°C"  //(temp.getString("temp").toFloat() - 273.15).toInt().toString()+"°C"

                val weather = obj.getJSONArray("weather")
                val fg = weather.getJSONObject(0)
                binding.tvWeather.text = fg.getString("main")

                if(binding.tvFail.text !="") binding.tvFail.text = ""
            },
            {
                binding.tvFail.text = "invalid input, please try again"
                Log.d(TAG,"error")
            })
        queue.add(stringRequest)
    }
    fun isNumber(s: String): Boolean {
        return try {
            s.toDouble()
            true
        } catch (ex: NumberFormatException) {
            false
        }
    }
}