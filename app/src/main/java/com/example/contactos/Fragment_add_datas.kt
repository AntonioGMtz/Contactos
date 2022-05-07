package com.example.contactos

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import com.example.contactos.MainActivity.Companion.editMode
import com.example.contactos.databinding.ActivityMainBinding.inflate
import com.example.contactos.databinding.ItemUserBinding.inflate
import com.example.contactos.databinding.FragmentAddDatasBinding
import com.example.contactos.databinding.FragmentAddDatasBinding.inflate
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Fragment_add_datas : Fragment() {


    private lateinit var mBinding : FragmentAddDatasBinding
    private var mActivity : MainActivity? = null
    private var misEditMode: Boolean = false
    private var mcontactoEntity : ContactosEntity? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //Bindeamos el fragment para presentarlo en patalla
        mBinding = FragmentAddDatasBinding.inflate(inflater,container, false)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getLong(getString(R.string.arg_id),0)
        if(id != null && id != 0L){
            misEditMode = true
            getStore(id)
        }else{
            misEditMode = false
            mcontactoEntity = ContactosEntity(nombre = "", aPaterno = "", aMaterno = "",edad = "", direccion = "",
            colonia = "",estado = "", poblacion = "", postal = "", Email = "", telefono = "" )
        }
        setupActionBar()

    }
    //funcion para llenar los campos con los datos de BDD traidos por el id
    private fun getStore(id: Long) {
        doAsync {
            mcontactoEntity = ContactosAplication.database.contactoDao().getStoreById(id) //Creamos la consulta
            uiThread {
                if(mcontactoEntity != null) setUiStore(mcontactoEntity!!)
            }
        }
    }
    //Funcion que trae la tienda y escribe los valores en ella
    private fun setUiStore(contactoEntity: ContactosEntity) {
        with(mBinding){
                etName.text = contactoEntity.nombre.editable()
                etApePat.text = contactoEntity.aPaterno.editable()
                etApeMat.text = contactoEntity.aMaterno.editable()
                etEdad.text = contactoEntity.edad.editable()
            etColonia.text = contactoEntity.colonia.editable()
            etDireccion.text = contactoEntity.direccion.editable()
            etEstado.text = contactoEntity.estado.editable()
            etPoblacion.text = contactoEntity.poblacion.editable()
            etCPostal.text = contactoEntity.postal.editable()
            etEmail.text = contactoEntity.Email.editable()
            etPhone.text = contactoEntity.poblacion.editable()

        }
    }
    //Funcion EXTENSION para poder pasar Strings en campos de texto
    private fun String.editable() : Editable = Editable.Factory.getInstance().newEditable(this)

    private fun setupActionBar(){
        //Castear el main Activity
        mActivity = activity as? MainActivity?
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity?.supportActionBar?.title = if(misEditMode) getString(R.string.contactos) else getString(R.string.nuevo_contacto)
    }



}