package com.example.contactos

import android.os.Bundle
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

class Fragment_add_datas : Fragment() {


    private lateinit var mBinding : FragmentAddDatasBinding
    private var mActivity : MainActivity? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //Bindeamos el fragment para presentarlo en patalla
        mBinding = FragmentAddDatasBinding.inflate(inflater,container, false)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar()

    }

    private fun setupActionBar(){
        editMode = false
        //Castear el main Activity
        mActivity = activity as? MainActivity?
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity?.supportActionBar?.title = if(editMode) getString(R.string.contactos) else getString(R.string.nuevo_contacto)
    }



}