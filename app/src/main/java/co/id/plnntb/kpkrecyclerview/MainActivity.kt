package co.id.plnntb.kpkrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.provider.SyncStateContract.Helpers.insert
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.plnntb.kpkrecyclerview.adapter.PelangganAdapter
import co.id.plnntb.kpkrecyclerview.model.Pelanggan
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.createTable
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.selector


class MainActivity : AppCompatActivity() {

    //buat variable untuk menampung data pelanggan
    var listPlg = mutableListOf<Pelanggan>()
    val adapterPlg = PelangganAdapter(listPlg)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTampilan()

        //masukkan data pelanggan ke Recycler View
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterPlg
        }

    }
    fun initTampilan(){
       btnsimpan.setOnClickListener {
           database.use {
               insert("pelanggan",
                   "idpel" to idpel.text,
                   "nama" to nama.text.toString(),
                   "alamat" to alamat.text.toString(),
                   "tarif" to tarif.text.toString(),
                   "daya" to daya.text.toString()
                   )
               listPlg.add(Pelanggan(
                   idpel.text.toString(),
                   nama.text.toString(),
                   alamat.text.toString(),
                   tarif.text.toString(),
                   daya.text.toString()
                   )
               )
           }
       }
    }

    override fun onResume() {
        bacaDatabase()
        super.onResume()
    }

    fun bacaDatabase(){
        database.use {
            select("pelanggan").exec {
                listPlg.clear()
                while (this.moveToNext()){
                    listPlg.add(Pelanggan(
                        getString(getColumnIndex("idpel")),
                        getString(getColumnIndex("nama")),
                        getString(getColumnIndex("alamat")),
                        getString(getColumnIndex("tarif")),
                        getString(getColumnIndex("daya"))
                    ))
                }

            }
        }}
}
