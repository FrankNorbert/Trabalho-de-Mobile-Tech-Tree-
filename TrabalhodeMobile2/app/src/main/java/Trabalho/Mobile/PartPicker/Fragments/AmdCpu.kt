package Trabalho.Mobile.PartPicker.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Trabalho.Mobile.R
import android.widget.BaseAdapter
import android.widget.ListView

/**
 * A simple [Fragment] subclass.
 */
class AmdCpu : Fragment() {

    lateinit var cpuList : ListView

    private val cpuAdapter = CpuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_amd_cpu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cpuList = view.findViewById(R.id.amd_cpu_list)
        //cpuList.adapter = cpuAdapter
    }

    internal class CpuAdapter : BaseAdapter(){
        override fun getCount(): Int {
            TODO("Not yet implemented")
        }

        override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            TODO("Not yet implemented")
        }

    }
}