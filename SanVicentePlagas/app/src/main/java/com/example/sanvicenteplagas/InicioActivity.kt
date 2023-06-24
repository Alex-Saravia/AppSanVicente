package com.example.sanvicenteplagas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicio.imgRegistroEvaluaciones
import kotlinx.android.synthetic.main.activity_inicio.imgRegistroEvaluadores
import kotlinx.android.synthetic.main.activity_inicio.imgRegistroFenologia
import kotlinx.android.synthetic.main.activity_inicio.imgRegistroTratamiento
import kotlinx.android.synthetic.main.activity_inicio.imgRegistroVariedades
import kotlinx.android.synthetic.main.activity_inicio.imgRegistrosCultivo
import kotlinx.android.synthetic.main.activity_inicio.imgRegistrosPlaga
import kotlinx.android.synthetic.main.activity_inicio.imgReporteEvaluaciones
import kotlinx.android.synthetic.main.activity_inicio.imgReporteTratamientos
import kotlinx.android.synthetic.main.activity_inicio.imgRutasEvaluaciones


class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        //Envio diferentes items
        imgRegistroEvaluaciones.setOnClickListener {
            RegistroEvaluaciones()
        }
        imgRegistroTratamiento.setOnClickListener {
            RegistroTratamientos()
        }
        imgRegistroEvaluadores.setOnClickListener {
            Evaluadores()
        }
        imgRegistrosCultivo.setOnClickListener {
            Cultivo()
        }
        imgRegistroVariedades.setOnClickListener {
            Variedad()
        }
        imgRegistroFenologia.setOnClickListener {
            Fenolofia()
        }
        imgRegistrosPlaga.setOnClickListener {
            Plaga()
        }
        imgRutasEvaluaciones.setOnClickListener {
            Rutas()
        }
        imgReporteEvaluaciones.setOnClickListener {
            ReporteEvaluaciones()
        }
        imgReporteTratamientos.setOnClickListener {
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