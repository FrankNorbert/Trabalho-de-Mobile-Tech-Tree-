package Trabalho.Mobile.PartPicker

import Trabalho.Mobile.PartPicker.Fragments.AmdGpu
import Trabalho.Mobile.PartPicker.Fragments.IntelGpu
import Trabalho.Mobile.PartPicker.Fragments.NvidiaGpu
import Trabalho.Mobile.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class GpuSelectorActivity : AppCompatActivity() {

    lateinit var nvidiaButton: Button
    lateinit var intelButton: Button
    lateinit var amdButton: Button

    lateinit var gpuFragmentView : FrameLayout

    var nvidiaGpuFragment = NvidiaGpu()
    var intelGpuFragment = IntelGpu()
    var amdGpuFragment = AmdGpu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gpu_selector)

        nvidiaButton = findViewById(R.id.gpu_nvidia_button)
        intelButton = findViewById(R.id.gpu_intel_button)
        amdButton = findViewById(R.id.gpu_amd_button)

        gpuFragmentView = findViewById(R.id.gpu_fragment_viewer)

        nvidiaButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.gpu_fragment_viewer,nvidiaGpuFragment)
                commit()
            }
        }
        intelButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.gpu_fragment_viewer,intelGpuFragment)
                commit()
            }
        }
        amdButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.gpu_fragment_viewer,amdGpuFragment)
                commit()
            }
        }
    }
}