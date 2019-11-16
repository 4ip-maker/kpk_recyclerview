package co.id.plnntb.kpkrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.plnntb.kpkrecyclerview.ViewHolder.PelangganViewHolder
import co.id.plnntb.kpkrecyclerview.model.Pelanggan

class PelangganAdapter(val list: List<Pelanggan>):
    RecyclerView.Adapter<PelangganViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PelangganViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PelangganViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: PelangganViewHolder, position: Int) {
        val data: Pelanggan = list[position]
        holder.bind(data)
    }
}