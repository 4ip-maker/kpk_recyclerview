package co.id.plnntb.kpkrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.plnntb.kpkrecyclerview.adapter.PelangganAdapter
import co.id.plnntb.kpkrecyclerview.model.Pelanggan
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //buat variable untuk menampung data pelanggan
    var listPlg = mutableListOf<Pelanggan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tambahkan data kedalam variable listPLg
        listPlg.add(Pelanggan("441234567890","Pelanggan A", "mataram", "B2","197000"))
        listPlg.add(Pelanggan("441234567890","Pelanggan B", "mataram", "B2","41500"))
        listPlg.add(Pelanggan("441234567890","Pelanggan C", "mataram", "B2","555000"))
        listPlg.add(Pelanggan("441234567890","Pelanggan D", "mataram", "B2","82500"))
        listPlg.add(Pelanggan("441234567890","Pelanggan E", "mataram", "B2","197000"))
        listPlg.add(Pelanggan("441234567890","Pelanggan F", "mataram", "B2","66000"))

        //masukkan data pelanggan ke Recycler View
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PelangganAdapter(listPlg)
        }

    }
}
