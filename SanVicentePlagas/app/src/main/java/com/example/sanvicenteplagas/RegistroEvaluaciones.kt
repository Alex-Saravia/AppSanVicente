package com.example.sanvicenteplagas

import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.sanvicenteplagas.databinding.ActivityRegistroEvaluacionesBinding
import com.example.sanvicenteplagas.databinding.ActivityReportesEvaluacionesBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Granularity
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference

class RegistroEvaluaciones : AppCompatActivity() {
    //Relacion con el activity
    private lateinit var binding: ActivityRegistroEvaluacionesBinding
    //Variables para subir imagenes
    private lateinit var firebaseRef: DatabaseReference
    private lateinit var storageRef: StorageReference
    private var uri: Uri? = null
    //Variables para obtener Ubicación
    private val CODIGO_PERMISO_SEGUNDO_PLANO = 100
    private var isPermisos = false
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroEvaluacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verificarPermisos()
    }

    //Codigo para la obtencion de imagenes
    fun insert_data(view : View){
        //val idEvaluaciones : String? = null,
        val numeroPlanta = binding.tvwnumeroPlanta.text.toString()
        val cultivo = binding.spnCultivo.selectedItem.toString()
        val variedad = binding.spnVariedad.toString()
        val fenologia = binding.spnFenologia.toString()
        val plaga = binding.tvwnumeroPlanta.text.toString()
        val latitud = binding.tvwnumeroPlanta.text.toString()
        val longitud = binding.tvwnumeroPlanta.text.toString()
        val imgURL = binding.tvwnumeroPlanta.text.toString()
    }
    fun insertarImagen(view: View){

    }
    //Codigo para obtener ubicación

    private fun verificarPermisos() {
        val permisos = arrayListOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )


        val permisosArray = permisos.toTypedArray()
        if (tienePermisos(permisosArray)) {
            isPermisos = true
            onPermisosConcedidos()
        } else {
            solicitarPermisos(permisosArray)
        }
    }

    private fun tienePermisos(permisos: Array<String>): Boolean {
        return permisos.all {
            return ContextCompat.checkSelfPermission(
                this,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun onPermisosConcedidos() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        try {
            fusedLocationClient.lastLocation.addOnSuccessListener {
                if (it != null) {
                    imprimirUbicacion(it)
                } else {
                    Toast.makeText(this, "No se puede obtener la ubicacion", Toast.LENGTH_SHORT).show()
                }
            }

            val locationRequest = LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY,
                30000
            ).apply {
                setGranularity(Granularity.GRANULARITY_PERMISSION_LEVEL)
                setWaitForAccurateLocation(true)
            }.build()

            locationCallback = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    super.onLocationResult(p0)

                    for (location in p0.locations) {
                        imprimirUbicacion(location)
                    }
                }
            }

            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        } catch (_: SecurityException) {

        }
    }

    private fun solicitarPermisos(permisos: Array<String>) {
        requestPermissions(
            permisos,
            CODIGO_PERMISO_SEGUNDO_PLANO
        )
    }

    private fun imprimirUbicacion(ubicacion: Location) {
        binding.tvwLatitud.text = "${ubicacion.latitude}"
        binding.tvwLongitud.text = "${ubicacion.longitude}"
        Log.d("GPS", "LAT: ${ubicacion.latitude} - LON: ${ubicacion.longitude}")
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CODIGO_PERMISO_SEGUNDO_PLANO) {
            val todosPermisosConcedidos =
                grantResults.all { it == PackageManager.PERMISSION_GRANTED }

            if (grantResults.isNotEmpty() && todosPermisosConcedidos) {
                isPermisos = true
                onPermisosConcedidos()
            }
        }
    }
}
