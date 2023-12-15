package com.example.bayrakquizuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bayrakquizuygulamasi.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySonucBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dogruSayısı = intent.getIntExtra("dogruSayac",0)

        binding.textViewSonuc.text = "Doğru : $dogruSayısı  Yanlış : ${5-dogruSayısı} "
        binding.textViewYuzdeSonuc.text = "% ${(dogruSayısı*100)/5} Başarı "


        binding.buttonTekrarDene.setOnClickListener(){
            startActivity(Intent(this@SonucActivity,QuizActivity::class.java))
            finish()
        }
    }
}