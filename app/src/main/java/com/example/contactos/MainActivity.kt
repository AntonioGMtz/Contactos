package com.example.contactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.contactos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding

    companion object{
         var editMode = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        editMode = true

        mBinding.fabAdd.setOnClickListener{
            launchEditFragment()
            mBinding.lilContenido.visibility = View.GONE
        }

    }


    private fun launchEditFragment(args : Bundle? = null) { //SINTAXIS BASICA PARA INICIAR UN FRAGMENT

        val fragment = Fragment_add_datas() //Instanciamos el Fragment
        if(args != null) fragment.arguments = args
        val fragmentManager = supportFragmentManager //Gestor para controlar los fragmentos
        val fragmentTransaction = fragmentManager.beginTransaction() //Dcide como ejecutar el fragment
        fragmentTransaction.add(R.id.containerMain,fragment) //LLAMA AL AFRAGMENT
        fragmentTransaction.commit()//Inicia el fragment
        fragmentTransaction.addToBackStack(null)
        //Si es true muestra el boton flotante si no lo esconde

    }
}