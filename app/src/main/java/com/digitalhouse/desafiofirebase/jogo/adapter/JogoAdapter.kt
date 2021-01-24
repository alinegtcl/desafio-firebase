package com.digitalhouse.desafiofirebase.jogo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.desafiofirebase.R
import com.digitalhouse.desafiofirebase.jogo.entities.Jogo
import com.digitalhouse.desafiofirebase.jogo.ui.DetalheJogoActivity
import com.squareup.picasso.Picasso

class JogoAdapter(val listaJogos: ArrayList<Jogo>, val context: Context): RecyclerView.Adapter<JogoAdapter.JogoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JogoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_jogo, parent, false)
        return JogoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        val currentItem = listaJogos[position]
        holder.nome.text = currentItem.nome.toString()
        Picasso.get().load(currentItem.url.toString())

        holder.url.setOnClickListener {
            context.startActivity(
                Intent(context, DetalheJogoActivity::class.java)
                    //.putExtra("jogo", currentItem)
            )
        }

    }

    override fun getItemCount(): Int {
        return listaJogos.size
    }

    class JogoViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var nome: TextView = itemView.findViewById(R.id.tvNomeJOgo)
        var ano: TextView = itemView.findViewById(R.id.tvAnoJogo)
//        var descricao: TextView = itemView.findViewById(R.id.)
        var url: ImageView = itemView.findViewById(R.id.ivJogo)

    }
}

