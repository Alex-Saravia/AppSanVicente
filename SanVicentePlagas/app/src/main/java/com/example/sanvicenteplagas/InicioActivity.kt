package com.example.sanvicenteplagas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sanvicenteplagas.databinding.ActivityInicioBinding



class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Envio diferentes items
        binding.imgRegistroEvaluaciones.setOnClickListener {
            RegistroEvaluaciones()
        }
        binding.imgRegistroTratamiento.setOnClickListener {
            RegistroTratamientos()
        }
        binding.imgRegistroEvaluadores.setOnClickListener {
            Evaluadores()
        }
        binding.imgRegistrosCultivo.setOnClickListener {
            Cultivo()
        }
        binding.imgRegistroVariedades.setOnClickListener {
            Variedad()
        }
        binding.imgRegistroFenologia.setOnClickListener {
            Fenolofia()
        }
        binding.imgRegistrosPlaga.setOnClickListener {
            Plaga()
        }
        binding.imgRutasEvaluaciones.setOnClickListener {
            Rutas()
        }
        binding.imgReporteEvaluaciones.setOnClickListener {
            ReporteEvaluaciones()
        }
        binding.imgReporteTratamientos.setOnClickListener {
            ReporteTratamientos()
        }
    }


    //Envio a diferentes ventanas
    private fun RegistroEvaluaciones(){
        val intentoE = Intent(this, RegistroEvaluaciones::class.java)
        startActivity(intentoE)
    }
    private fun RegistroTratamientos(){
        val intentoE = Intent(this, RegistroTratamientos::class.java)
        startActivity(intentoE)
    }
    private fun Evaluadores(){
        val intentoE = Intent(this, RegEvaluadores::class.java)
        startActivity(intentoE)
    }
    private fun Cultivo(){
        val intentoE = Intent(this, RegCultivo::class.java)
        startActivity(intentoE)
    }
    private fun Variedad(){
        val intentoE = Intent(this, RegVariedad::class.java)
        startActivity(intentoE)
    }
    private fun Fenolofia(){
        val intentoE = Intent(this, RegFenologia::class.java)
        startActivity(intentoE)
    }
    private fun Plaga(){
        val intentoE = Intent(this, RegPlaga::class.java)
        startActivity(intentoE)
    }
    private fun Rutas(){
        val intentoE = Intent(this, RutasEvaluaciones::class.java)
        startActivity(intentoE)
    }
    private fun ReporteEvaluaciones(){
        val intentoE = Intent(this, ReportesEvaluaciones::class.java)
        startActivity(intentoE)
    }
    private fun ReporteTratamientos(){
        val intentoRT = Intent(this, ReportesTratamientos::class.java)
        startActivity(intentoRT)
    }
}