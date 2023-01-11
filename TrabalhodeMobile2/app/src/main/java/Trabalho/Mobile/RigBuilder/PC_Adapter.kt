package Trabalho.Mobile.RigBuilder

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class PC_Adapter(pcArrayList: ArrayList<PC>) : BaseAdapter() {

    var pcArrayList = pcArrayList

    override fun getCount(): Int {
        return this.pcArrayList.size
    }

    override fun getItem(p0: Int): Any {
        return this.pcArrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}