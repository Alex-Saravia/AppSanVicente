package com.example.sanvicenteplagas

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.analytics.FirebaseAnalytics
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.btnIngresar
import kotlinx.android.synthetic.main.activity_login.btnRegistrar
import kotlinx.android.synthetic.main.activity_login.edtPassword
import kotlinx.android.synthetic.main.activity_login.edtUsuario

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","Integración completa de Firebase")
        analytics.logEvent("InitScreem", bundle)

        setup()

    }
    private fun setup() {
        title = "Autentificación"
        btnRegistrar.setOnClickListener {
            if(edtUsuario.text.isNotEmpty() && edtPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(edtUsuario.text.toString(), edtPassword.text.toString())
                    .addOnCompleteListener {

                        if(it.isSuccessful){
                            menuInicio()
                        }else{
                            showAlert()
                        }
                    }
            }
        }
        btnIngresar.setOnClickListener {
            if(edtUsuario.text.isNotEmpty() && edtPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(edtUsuario.text.toString(), edtPassword.text.toString()).addOnCompleteListener {

                        if(it.isSuccessful){
                            menuInicio()
                        }else{
                            showAlert()
                        }
                    }
            }
        }
    }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al ingresar credenciales")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
        }
    /*private fun menuInicioUser(email: String, provider: ProviderType){
        val homeIntent = Intent(this, InicioActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }*/
    private fun menuInicio(){
        val intento1 = Intent(this, InicioActivity::class.java)
        startActivity(intento1)
    }
    }






