package com.example.contactos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactos.databinding.ItemUserBinding

class ContactoAdapter(private var contactos : MutableList<ContactosEntity>, private var listener : View.OnClickListener):
    RecyclerView.Adapter<ContactoAdapter.ViewHolder>() {

    private lateinit var mContext : Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemUserBinding.bind(view)

      /* fun setListener(contactoEntity:ContactoEntity){
            with(binding.root){  //Agrupa los binding en UNO solo
                setOnClickListener{  //Un clic nos lleva al detalle de la tienda
                    listener.onClick(storeEntity.id)
                    if(storeEntity.ip == "Email") myFragment = 1
                    else if(storeEntity.ip == "Cuenta") myFragment = 2
                    else myFragment = 3
                }
                setOnLongClickListener{ //un clid largo nos eliminara la tienda
                    listener.onDeleteStore(storeEntity) //debemos regresar un booleano
                    true
                }
                binding.cbFavorite.setOnClickListener{
                    listener.onFavoriteStore(storeEntity)
                }
            }
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_user,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = contactos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactos.get(position)
        with(holder){
            //Bindeando los campos de la app
           // setListener(contactos)
            binding.tvName.text = contacto.nombre
        }
    }

    fun add(contactoEntity: ContactosEntity) {
        if(!contactos.contains(contactoEntity)){
            contactos.add(contactoEntity) //Añadir el dato store
            //refrescar el dato en pantalla
            notifyItemChanged(contactos.size-1)
        }

    }
    fun setStore(contactos: MutableList<ContactosEntity>) {
        this.contactos = contactos
        notifyDataSetChanged()
    }
    //metodo para actualizar el estado de la tienda
    fun update(contactosEntity: ContactosEntity) {
        //saber el indice en el cual esta la tienda
        val index= contactos.indexOf(contactosEntity)
        if(index !=-1){
            contactos.set(index,contactosEntity)
            //solamente refresca el registro afectado
            notifyItemChanged(index)
        }
    }
    fun delete(storeEntity: ContactosEntity) {

        //saber el indice en el cual esta la tienda
        val index= contactos.indexOf(storeEntity)
        if(index !=-1){
            //Removemos la tienda
            contactos.removeAt(index)
            //refresaca la vista con el elemento eliminado
            notifyItemRemoved(index)
        }
    }
}