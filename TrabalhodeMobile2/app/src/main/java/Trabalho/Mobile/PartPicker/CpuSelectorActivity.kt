package Trabalho.Mobile.PartPicker

import Trabalho.Mobile.PartPicker.Fragments.AmdCpu
import Trabalho.Mobile.PartPicker.Fragments.IntelCpu
import Trabalho.Mobile.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class CpuSelectorActivity : AppCompatActivity() {

    lateinit var intelButton: Button
    lateinit var amdButton: Button
    lateinit var cpuFragmentView : FrameLayout

    var intelCpuFragment = IntelCpu()
    var amdCpuFragment = AmdCpu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cpu_selector)

        intelButton = findViewById(R.id.cpu_selector_intel)
        amdButton = findViewById(R.id.cpu_selector_amd)

        cpuFragmentView = findViewById(R.id.cpu_fragment_viewer)

        intelButton.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.cpu_fragment_viewer,intelCpuFragment)
                commit()
            }
        }

        amdButton.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.cpu_fragment_viewer,amdCpuFragment)
                commit()
            }
        }
    }
}