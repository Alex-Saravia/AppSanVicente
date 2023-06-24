package com.example.sanvicenteplagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sanvicenteplagas.Modelo.Cultivo
import com.example.sanvicenteplagas.databinding.ActivityRegCultivoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegCultivo : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    private lateinit var binding : ActivityRegCultivoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegCultivoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAgregarCultivo.setOnClickListener {
            insertar_datos()
        }
    }
    fun insertar_datos() {
        val nombreCultivo = binding.edtNombreCultivo.text.toString()
        database = FirebaseDatabase.getInstance().getReference("Cultivos")
        val cultivos = Cultivo(nombreCultivo)
        val databaseReference = FirebaseDatabase.getInstance().reference
        val id = databaseReference.push().key
        database.child(id.toString()).setValue(cultivos).addOnCompleteListener {
            binding.edtNombreCultivo.text.clear()
            Toast.makeText(this, "Datos registrados correctamente", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "No se registraros los datos", Toast.LENGTH_SHORT).show()
        }
    }
}