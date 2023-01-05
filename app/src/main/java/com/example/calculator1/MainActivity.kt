package com.example.calculator1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var amal = -1
    var number1 = 0.0
    var number2 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener{raqamYoz("0")}
        btn_1.setOnClickListener{raqamYoz("1")}
        btn_2.setOnClickListener{raqamYoz("2")}
        btn_3.setOnClickListener{raqamYoz("3")}
        btn_4.setOnClickListener{raqamYoz("4")}
        btn_5.setOnClickListener{raqamYoz("5")}
        btn_6.setOnClickListener{raqamYoz("6")}
        btn_7.setOnClickListener{raqamYoz("7")}
        btn_8.setOnClickListener{raqamYoz("8")}
        btn_9.setOnClickListener{raqamYoz("9")}
        btn_delete.setOnClickListener{delete()}
        btn_ac.setOnClickListener{result_tv.text = "0"}
        btn_dot.setOnClickListener{writeDot()}
        btn_plus.setOnClickListener{amalYoz(0)}
        btn_minus.setOnClickListener{amalYoz(1 )}
        btn_multiply.setOnClickListener{amalYoz(2 )}
        btn_divide1.setOnClickListener{amalYoz(3 )}

        btn_equals.setOnClickListener{MyEquel()}

    }
    fun raqamYoz(raqam: String){
        var tvEkran = result_tv.text.toString()
        if(tvEkran == "0"){
            tvEkran = raqam
        }else{
            tvEkran += raqam
        }

        result_tv.text = tvEkran
    }
    fun delete() {
        var ekran = result_tv.text.toString()
        if (ekran.length == 1) {
            result_tv.text = "0"
        } else {
            result_tv.text = ekran.substring(0, ekran.length-1)

        }
    }
    fun writeDot(){
        var ekran = result_tv.text.toString()
        if(!ekran.contains('.')){
            ekran+= "."
            result_tv.text = ekran
        }
    }


    private fun amalYoz(amal: Int){
   this.amal = amal
        number1 = result_tv.text.toString().toDouble()
        result_tv.text = "0"
    }
    @SuppressLint("SetTextI18n")
    private fun MyEquel(){
        number2 = result_tv.text.toString().toDouble()

        when(amal){
            0->{ result_tv.text = (number1+number2).toString()}
             1->{   result_tv.text = (number1-number2).toString()}
             2->{   result_tv.text = (number1*number2).toString()}
             3->{   result_tv.text = (number1/number2).toString() }
        }
    }
}